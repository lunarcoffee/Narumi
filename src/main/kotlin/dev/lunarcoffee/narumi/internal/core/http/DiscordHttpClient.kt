package dev.lunarcoffee.narumi.internal.core.http

import io.ktor.client.HttpClient
import io.ktor.client.features.json.JsonFeature
import io.ktor.client.request.get

internal class DiscordHttpClient {
    private val client = HttpClient { install(JsonFeature) }

    internal suspend fun getGateway(): String {
        val response = client.get<Map<String, String>>("$URI_ROOT/gateway")
        return response["url"]!! + "/?v=6&encoding=json&compress=zlib-stream"
    }

    companion object {
        private const val URI_ROOT = "https://discordapp.com/api/v6"
    }
}
