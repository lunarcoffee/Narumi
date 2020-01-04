package dev.lunarcoffee.narumi.internal.core.gateway.manager

import dev.lunarcoffee.narumi.internal.core.gateway.WebSocketConnection
import java.net.URI

internal interface ConnectionManager {
    val curConn: WebSocketConnection

    suspend fun connect(uri: URI)
    suspend fun stop()
}
