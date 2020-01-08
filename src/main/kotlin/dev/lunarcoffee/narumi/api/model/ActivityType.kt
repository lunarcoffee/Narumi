package dev.lunarcoffee.narumi.api.model

enum class ActivityType(val code: Int) {
    GAME(0),
    STREAMING(1),
    LISTENING(2),
    CUSTOM(4)
}
