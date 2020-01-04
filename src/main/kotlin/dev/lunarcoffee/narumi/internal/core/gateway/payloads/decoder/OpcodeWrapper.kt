package dev.lunarcoffee.narumi.internal.core.gateway.payloads.decoder

import com.google.gson.annotations.SerializedName
import dev.lunarcoffee.narumi.internal.core.gateway.payloads.GatewayPayload

internal class OpcodeWrapper(
    @SerializedName("op") override val opcode: Int
) : GatewayPayload<Unit> {

    override val data = Unit
}
