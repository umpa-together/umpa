package com.umpa.core.domain.feed

import com.umpa.commons.enums.ContentType
import com.umpa.storage.db.core.feed.FeedEntity

data class FeedCreation(
    val userId: Long,
    val contentId: Long,
    val contentType: ContentType
) {
    fun toEntity(): FeedEntity {
        return FeedEntity(
            userId = userId,
            contentId = contentId,
            contentType = contentType
        )
    }
}
