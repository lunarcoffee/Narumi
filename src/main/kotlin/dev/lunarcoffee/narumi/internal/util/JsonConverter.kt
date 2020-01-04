package dev.lunarcoffee.narumi.internal.util

import com.google.gson.GsonBuilder

internal class JsonConverter {
    private val gson = GsonBuilder().serializeNulls().create()

    fun serialize(obj: Any) = gson.toJson(obj)!!
    inline fun <reified T> deserialize(json: String) = gson.fromJson(json, T::class.java)!!
}
