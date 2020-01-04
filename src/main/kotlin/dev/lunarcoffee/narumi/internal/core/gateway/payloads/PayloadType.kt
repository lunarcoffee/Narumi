package dev.lunarcoffee.narumi.internal.core.gateway.payloads

internal enum class PayloadType(internal val opcode: Int) {
    DISPATCH(0),
    HEARTBEAT(1),
    IDENTIFY(2),
    STATUS_UPDATE(3),
    VOICE_STATE_UPDATE(4),
    RESUME(6),
    RECONNECT(7),
    REQUEST_GUILD_MEMBERS(8),
    INVALID_SESSION(9),
    HELLO(10),
    HEARTBEAT_ACK(11);

    companion object {
        private val opcodeToType = values().associateBy { it.opcode }

        internal fun getByOpcode(opcode: Int) = opcodeToType[opcode]!!
    }
}
