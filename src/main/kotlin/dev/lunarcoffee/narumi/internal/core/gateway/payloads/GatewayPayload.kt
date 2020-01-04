package dev.lunarcoffee.narumi.internal.core.gateway.payloads

internal interface GatewayPayload<T> {
    val opcode: Int
    val type get() = PayloadType.getByOpcode(opcode)

    val data: T
    val sequence: Int? get() = null
    val name: String? get() = null
}
