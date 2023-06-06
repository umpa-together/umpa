package com.umpa.core.domain.feed

import com.umpa.ContentType
import com.umpa.feed.FeedEntity

data class FeedCreation(
    val uploadUserId: Long,
    val contentId: Long,
    val contentType: ContentType
) {
    fun toEntity(): FeedEntity {
        return FeedEntity(
            uploadUserId = uploadUserId,
            contentId = contentId,
            contentType = contentType
        )
    }
}
