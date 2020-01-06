package dev.lunarcoffee.narumi.internal.core.gateway.payloads

import com.google.gson.annotations.SerializedName
import dev.lunarcoffee.narumi.api.model.Presence

internal class IdentifyPayload(override val data: Data) : GatewayPayload<IdentifyPayload.Data> {
    override val opcode = PayloadType.IDENTIFY.opcode

    internal inner class Data(
        internal val token: String,
        internal val properties: Map<String, String>,
        internal val presence: Presence
    ) {
        @SerializedName("large_threshold")
        internal val largeThreshold = 250
        internal val compress = true
        internal val shard: IntArray? = null
    }
}
