package dev.lunarcoffee.narumi.api.model

interface Activity {
    val type: ActivityType
    val typeInt get() = type.code

    val name: String
    val url: String?
}
