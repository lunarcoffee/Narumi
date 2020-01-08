package dev.lunarcoffee.narumi.internal.core.gateway.heartbeater

import dev.lunarcoffee.narumi.internal.core.gateway.GatewayConnection
import dev.lunarcoffee.narumi.internal.core.gateway.payloads.HeartbeatAckPayload
import dev.lunarcoffee.narumi.internal.core.gateway.payloads.HeartbeatPayload
import kotlinx.atomicfu.atomic
import kotlinx.atomicfu.update
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.isActive

internal class GatewayHeartbeater(
    private val scope: CoroutineScope,
    private val curConn: GatewayConnection,
    private val heartbeatMs: Long
) : Heartbeater {

    private var ackReceived = atomic(false)
    private var sequence: Int? = null

    override suspend fun start() {
        curConn.onPayload.register {
            sequence = it?.sequence
            if (it is HeartbeatAckPayload)
                ackReceived.update { true }
        }
        heartbeatLoop()
    }

    private suspend fun heartbeatLoop() {
        while (scope.isActive) {
            curConn.send(HeartbeatPayload(sequence))
            delay(heartbeatMs) // TODO: subtract time to account for execution time?

            if (!ackReceived.value)
            // TODO: Throw new exception to indicate a reconnection should be attempted.
                throw IllegalStateException("Expected heartbeat acknowledgement!")
        }
    }
}
