package dev.lunarcoffee.narumi.api.model

class DefaultPresence(
    override val since: Int?,
    override val game: Activity?,
    override val status: PresenceStatus,
    override val afk: Boolean
) : Presence
