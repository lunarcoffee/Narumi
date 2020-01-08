package dev.lunarcoffee.narumi.api.model

interface Presence {
    val since: Int?
    val game: Activity?
    val status: PresenceStatus
    val statusString get() = status.repr
    val afk: Boolean
}
