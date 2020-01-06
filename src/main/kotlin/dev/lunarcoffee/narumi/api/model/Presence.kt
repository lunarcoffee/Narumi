package dev.lunarcoffee.narumi.api.model

interface Presence {
    val since: Int?
    val game: Activity?
    val status: String
    val afk: Boolean
}
