package dev.lunarcoffee.narumi.internal.core.gateway.manager

import dev.lunarcoffee.narumi.internal.core.gateway.DefaultGatewayConnection
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.net.URI

// TODO: Resume/reconnect mechanics.
internal class GatewayConnectionManager : ConnectionManager {
    private val connScope = CoroutineScope(Dispatchers.IO)
    override val curConn = DefaultGatewayConnection(connScope)

    override suspend fun connect(uri: URI) {
        connScope.launch { curConn.connect(uri) }
    }

    override suspend fun stop() {
        curConn.close()
    }
}
