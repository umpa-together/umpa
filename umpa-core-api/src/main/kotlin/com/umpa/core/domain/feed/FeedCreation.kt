package com.umpa.core.domain.feed

import com.umpa.commons.enums.ContentType
import com.umpa.storage.db.core.feed.FeedEntity

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
