package dev.lunarcoffee.narumi.internal.core.gateway.payloads.decoder

import dev.lunarcoffee.narumi.internal.core.gateway.payloads.*
import dev.lunarcoffee.narumi.internal.core.gateway.payloads.PayloadType
import dev.lunarcoffee.narumi.internal.util.JsonConverter

internal class PayloadDecoder : SuspendPayloadDecoder {
    private val jsonConverter = JsonConverter()

    override suspend fun decode(json: String): GatewayPayload<*> {
        return when (jsonConverter.deserialize<OpcodeWrapper>(json).type) {
            PayloadType.DISPATCH -> jsonConverter.deserialize<OpcodeWrapper>(json) // TODO:
            PayloadType.HEARTBEAT -> jsonConverter.deserialize<HeartbeatPayload>(json) // TODO:
            PayloadType.IDENTIFY -> jsonConverter.deserialize<IdentifyPayload>(json) // TODO:
            PayloadType.STATUS_UPDATE -> jsonConverter.deserialize<OpcodeWrapper>(json) // TODO:
            PayloadType.VOICE_STATE_UPDATE -> jsonConverter.deserialize<OpcodeWrapper>(json) // TODO:
            PayloadType.RESUME -> jsonConverter.deserialize<OpcodeWrapper>(json) // TODO:
            PayloadType.RECONNECT -> jsonConverter.deserialize<OpcodeWrapper>(json) // TODO:
            PayloadType.REQUEST_GUILD_MEMBERS -> jsonConverter.deserialize<OpcodeWrapper>(json) // TODO:
            PayloadType.INVALID_SESSION -> jsonConverter.deserialize<OpcodeWrapper>(json) // TODO:
            PayloadType.HELLO -> jsonConverter.deserialize<HelloPayload>(json)
            PayloadType.HEARTBEAT_ACK -> jsonConverter.deserialize<HeartbeatAckPayload>(json) // TODO: // TODO:
        }
    }
}
