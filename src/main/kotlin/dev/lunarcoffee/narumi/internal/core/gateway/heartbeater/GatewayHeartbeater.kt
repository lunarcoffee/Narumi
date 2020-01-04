package dev.lunarcoffee.narumi.internal.core.gateway.heartbeater

import dev.lunarcoffee.narumi.internal.core.gateway.GatewayConnection
import dev.lunarcoffee.narumi.internal.core.gateway.payloads.HeartbeatPayload
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.isActive

internal class GatewayHeartbeater(
    private val scope: CoroutineScope,
    private val curConn: GatewayConnection,
    private val heartbeatMs: Long
) : Heartbeater {

    private var sequence: Int? = null

    override suspend fun start() {
        curConn.onPayload.register { sequence = it?.sequence }
        heartbeatLoop()
    }

    private suspend fun heartbeatLoop() {
        while (scope.isActive) {
            curConn.send(HeartbeatPayload(sequence))
            delay(heartbeatMs) // TODO: subtract time to account for execution time?

            // TODO: check for ack
        }
    }
}
