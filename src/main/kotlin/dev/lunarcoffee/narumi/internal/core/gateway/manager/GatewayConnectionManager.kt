package dev.lunarcoffee.narumi.internal.core.gateway.manager

import dev.lunarcoffee.narumi.internal.core.gateway.DefaultGatewayConnection
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

// TODO: Resume/reconnect mechanics.
internal class GatewayConnectionManager(token: String) : ConnectionManager {
    private val connScope = CoroutineScope(Dispatchers.IO)
    override val curConn = DefaultGatewayConnection(token, connScope)

    override suspend fun connect(url: String) {
        connScope.launch { curConn.connect(url) }
    }

    override suspend fun stop() {
        curConn.close()
    }
}
