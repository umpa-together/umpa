package com.umpa.core.domain.hashtag

import com.umpa.hashtag.HashtagEntity

data class HashtagCreation(
    val hashtag: String,
    val contentId: Long
) {
    fun toEntity(): HashtagEntity {
        return HashtagEntity(
            hashtag = hashtag,
            contentId = contentId
        )
    }
}
