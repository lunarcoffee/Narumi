package dev.lunarcoffee.narumi.internal.core.gateway.heartbeater

internal interface Heartbeater {
    // This should run a loop which blocks, heartbeating.
    suspend fun start()
}
