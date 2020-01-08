package dev.lunarcoffee.narumi.api.model

class DefaultActivity(
    override val name: String,
    override val type: ActivityType,
    override val url: String? = null
) : Activity
