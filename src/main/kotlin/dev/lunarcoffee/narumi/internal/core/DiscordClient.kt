package dev.lunarcoffee.narumi.internal.core

import dev.lunarcoffee.narumi.internal.core.gateway.manager.GatewayConnectionManager
import dev.lunarcoffee.narumi.internal.core.http.DiscordHttpClient
import java.net.URI

// TODO: Expose api properly (in package 'api').
class DiscordClient : Client {
    private val connManager = GatewayConnectionManager()
    private val httpClient = DiscordHttpClient()

    override suspend fun start() {
        val gatewayUri = URI(httpClient.getGateway())
        println(gatewayUri.toString())
        connManager.connect(gatewayUri)
    }

    override suspend fun stop() {
        connManager.stop()
    }
}
