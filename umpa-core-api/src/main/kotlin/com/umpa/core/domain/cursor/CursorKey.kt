package com.umpa.core.domain.cursor

import java.util.Base64

data class CursorKey(
    val limit: Int?,
    val offset: Int?
) {
    fun encode(): String? = Base64.getEncoder().encodeToString("$limit:$offset".toByteArray())

    companion object {
        fun fromBase64(key: String): CursorKey {
            val decodedKey = String(Base64.getDecoder().decode(key))
                .split(":")
            return CursorKey(
                limit = decodedKey[0].toIntOrNull(),
                offset = decodedKey[1].toIntOrNull()
            )
        }

        fun extractFromUrl(url: String): CursorKey {
            val separatorIndex = url.indexOf("?")
            var limit: Int? = null
            var offset: Int? = null
            url.substring(separatorIndex + 1).split("&")
                .forEach {
                    val (key, value) = it.split("=")
                    when (key) {
                        "limit" -> limit = value.toIntOrNull()
                        "offset" -> offset = value.toIntOrNull()
                    }
                }
            return CursorKey(limit = limit, offset = offset)
        }
    }
}
