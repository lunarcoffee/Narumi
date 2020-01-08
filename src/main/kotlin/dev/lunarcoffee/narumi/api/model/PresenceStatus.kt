package dev.lunarcoffee.narumi.api.model

enum class PresenceStatus(val repr: String) {
    ONLINE("online"),
    DO_NOT_DISTURB("dnd"),
    IDLE("idle"),
    INVISIBLE("invisible"),
    OFFLINE("offline")
}
