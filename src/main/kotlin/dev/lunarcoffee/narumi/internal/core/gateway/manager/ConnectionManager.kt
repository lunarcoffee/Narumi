package dev.lunarcoffee.narumi.internal.core.gateway.manager

import dev.lunarcoffee.narumi.internal.core.gateway.WebSocketConnection

internal interface ConnectionManager {
    val curConn: WebSocketConnection

    suspend fun connect(url: String)
    suspend fun stop()
}
