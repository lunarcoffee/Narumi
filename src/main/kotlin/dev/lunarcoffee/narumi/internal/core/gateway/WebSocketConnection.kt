package dev.lunarcoffee.narumi.internal.core.gateway

import dev.lunarcoffee.narumi.internal.util.events.Event
import java.net.URI

internal interface WebSocketConnection {
    val onTextMessage: Event<String>?
    val onBinaryMessage: Event<ByteArray>?
    val onClose: Event<Unit>?

    suspend fun connect(uri: URI)
    suspend fun send(data: ByteArray)
    suspend fun close()
}
