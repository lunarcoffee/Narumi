package dev.lunarcoffee.narumi.internal.core.gateway.payloads

internal class HeartbeatAckPayload : GatewayPayload<Unit> {
    override val data = Unit
    override val opcode = PayloadType.HEARTBEAT_ACK.opcode
}
