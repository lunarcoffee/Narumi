package dev.lunarcoffee.narumi.internal.core.gateway.payloads.decoder

import dev.lunarcoffee.narumi.internal.core.gateway.payloads.GatewayPayload

internal interface SuspendPayloadDecoder {
    suspend fun decode(json: String): GatewayPayload<*>
}
