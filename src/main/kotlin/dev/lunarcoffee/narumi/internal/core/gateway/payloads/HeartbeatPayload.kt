package dev.lunarcoffee.narumi.internal.core.gateway.payloads

internal class HeartbeatPayload(override val data: Int?) : GatewayPayload<Int?> {
    override val opcode = PayloadType.HEARTBEAT.opcode
}
