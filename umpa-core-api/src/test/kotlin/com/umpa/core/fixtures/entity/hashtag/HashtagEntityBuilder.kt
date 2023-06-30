package com.umpa.core.fixtures.entity.hashtag

import com.umpa.storage.db.core.hashtag.HashtagEntity

class HashtagEntityBuilder(
    val hashtag: String = "",
    val contentId: Long = 0L,
    val isDeleted: Boolean = false
) {
    fun build(): HashtagEntity {
        return HashtagEntity(
            hashtag = hashtag,
            contentId = contentId,
            isDeleted = isDeleted,
        )
    }
}
