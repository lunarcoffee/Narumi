package dev.lunarcoffee.narumi.internal.core.gateway.payloads

import com.google.gson.annotations.SerializedName

internal class HelloPayload(override val data: Data) : GatewayPayload<HelloPayload.Data> {
    override val opcode = PayloadType.HELLO.opcode

    internal class Data(@SerializedName("heartbeat_interval") internal val heartbeatMs: Int)
}
