package dev.lunarcoffee.narumi.internal.core.gateway

import dev.lunarcoffee.narumi.internal.core.gateway.heartbeater.GatewayHeartbeater
import dev.lunarcoffee.narumi.internal.core.gateway.payloads.GatewayPayload
import dev.lunarcoffee.narumi.internal.core.gateway.payloads.HelloPayload
import dev.lunarcoffee.narumi.internal.core.gateway.payloads.decoder.PayloadDecoder
import dev.lunarcoffee.narumi.internal.util.JsonConverter
import dev.lunarcoffee.narumi.internal.util.ZlibInflater
import dev.lunarcoffee.narumi.internal.util.events.DefaultEvent
import io.ktor.client.HttpClient
import io.ktor.client.features.websocket.webSocketSession
import io.ktor.http.cio.websocket.Frame
import io.ktor.http.cio.websocket.WebSocketSession
import io.ktor.http.cio.websocket.readText
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.cancel
import kotlinx.coroutines.isActive
import kotlinx.coroutines.runBlocking
import java.net.URI
import kotlin.concurrent.thread

internal class DefaultGatewayConnection(private val scope: CoroutineScope) : GatewayConnection() {
    override val onPayload = DefaultEvent<GatewayPayload<*>>()
    override val onClose = DefaultEvent<Unit>()

    private val client = HttpClient()
    private lateinit var ws: WebSocketSession

    private val payloadDecoder = PayloadDecoder()
    private val jsonConverter = JsonConverter()
    private val inflater = ZlibInflater()

    override suspend fun connect(uri: URI) {
        ws = client.webSocketSession(host = uri.host, port = uri.port, path = uri.path)
        receiveLoop()
    }

    override suspend fun send(data: GatewayPayload<*>) {
        val json = jsonConverter.serialize(data).toByteArray()
        send(json)
    }

    // Use within this class only.
    override suspend fun send(data: ByteArray) {
        ws.outgoing.send(Frame.Binary(true, data))
    }

    override suspend fun close() = scope.cancel()

    // Receive initial connection information and send identify payload.
    private suspend fun handshake() {
        val hello = receive()
        if (hello !is HelloPayload)
            throw IllegalStateException() // TODO:

        thread(true) {
            runBlocking {
                GatewayHeartbeater(scope, this@DefaultGatewayConnection, hello.data.heartbeatMs.toLong()).start()
            }
        }

        // TODO: send identify
    }

    private suspend fun receiveLoop() {
        handshake()

        while (scope.isActive) {
            val payload = receive() ?: break
            onPayload.fire(payload)
        }
    }

    private suspend fun receive(): GatewayPayload<*>? {
        val frame = runCatching { ws.incoming.receive() }.getOrNull()

        if (frame == null || frame is Frame.Close) {
            close()
            return null
        }

        return when (frame) {
            is Frame.Binary -> payloadDecoder.decode(inflater.inflate(frame.data).toString(Charsets.UTF_8))
            is Frame.Text -> payloadDecoder.decode(frame.readText())
            else -> throw IllegalStateException()
        }
    }
}
