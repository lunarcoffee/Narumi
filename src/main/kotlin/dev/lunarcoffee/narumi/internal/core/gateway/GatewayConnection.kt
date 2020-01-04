package dev.lunarcoffee.narumi.internal.core.gateway

import dev.lunarcoffee.narumi.internal.core.gateway.payloads.GatewayPayload
import dev.lunarcoffee.narumi.internal.util.events.Event

internal abstract class GatewayConnection : WebSocketConnection {
    override val onTextMessage: Event<String>? = null
    override val onBinaryMessage: Event<ByteArray>? = null

    abstract val onPayload: Event<GatewayPayload<*>>
    abstract override val onClose: Event<Unit>

    abstract suspend fun send(data: GatewayPayload<*>)
}
