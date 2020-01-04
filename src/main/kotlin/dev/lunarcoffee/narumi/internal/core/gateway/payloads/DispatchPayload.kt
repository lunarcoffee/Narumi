package dev.lunarcoffee.narumi.internal.core.gateway.payloads

// TODO:
internal class DispatchPayload(override val data: Unit) : GatewayPayload<Unit> {
    override val opcode = PayloadType.DISPATCH.opcode
}
