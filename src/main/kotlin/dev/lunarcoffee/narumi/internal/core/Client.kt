package dev.lunarcoffee.narumi.internal.core

interface Client {
    suspend fun start()
    suspend fun stop()
}
