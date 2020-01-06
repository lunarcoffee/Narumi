package dev.lunarcoffee.narumi.api.model

class UserPresence(
    override val since: Int?,
    override val game: Activity?,
    override val status: String,
    override val afk: Boolean
) : Presence
