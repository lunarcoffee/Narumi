package dev.lunarcoffee.narumi.internal.util.events

internal interface Event<T> {
    val handlers: MutableList<suspend (T?) -> Unit>

    fun register(handler: suspend (T?) -> Unit)
    fun unregister(handler: suspend (T?) -> Unit)

    suspend fun fire(data: T? = null)
}
