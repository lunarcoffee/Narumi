package dev.lunarcoffee.narumi.internal.util

import java.util.zip.Inflater

internal class ZlibInflater {
    fun inflate(bytes: ByteArray): ByteArray {
        return Inflater().run {
            setInput(bytes)
            ByteArray(OUTPUT_SIZE).apply { inflate(this) }
        }
    }

    companion object {
        private const val OUTPUT_SIZE = 256 * 1_024
    }
}
