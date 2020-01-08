package dev.lunarcoffee.narumi.internal.core.gateway

import dev.lunarcoffee.narumi.internal.util.events.Event

internal interface WebSocketConnection {
    val onTextMessage: Event<String>?
    val onBinaryMessage: Event<ByteArray>?
    val onClose: Event<Unit>?

    suspend fun connect(url: String)
    suspend fun send(data: ByteArray)
    suspend fun close()
}
