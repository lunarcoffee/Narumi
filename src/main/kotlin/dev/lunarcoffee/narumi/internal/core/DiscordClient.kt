package dev.lunarcoffee.narumi.internal.core

import dev.lunarcoffee.narumi.internal.core.gateway.manager.GatewayConnectionManager
import dev.lunarcoffee.narumi.internal.core.http.DiscordHttpClient

// TODO: Expose api properly (in package 'api').
class DiscordClient(token: String) : Client {
    private val connManager = GatewayConnectionManager(token)
    private val httpClient = DiscordHttpClient()

    override suspend fun start() {
        val gatewayUrl = httpClient.getGateway()
        connManager.connect(gatewayUrl)
    }

    override suspend fun stop() {
        connManager.stop()
    }
}
