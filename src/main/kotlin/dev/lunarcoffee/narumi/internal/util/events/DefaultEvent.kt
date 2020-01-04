package dev.lunarcoffee.narumi.internal.util.events

internal class DefaultEvent<T> : Event<T> {
    override val handlers = mutableListOf<suspend (T?) -> Unit>()

    override fun register(handler: suspend (T?) -> Unit) {
        handlers += handler
    }

    override fun unregister(handler: suspend (T?) -> Unit) {
        handlers -= handler
    }

    override suspend fun fire(data: T?) = handlers.forEach { it(data) }
}
