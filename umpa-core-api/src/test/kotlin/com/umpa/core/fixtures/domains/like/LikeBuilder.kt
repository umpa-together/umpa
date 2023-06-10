package com.umpa.core.fixtures.domains.like

import com.umpa.commons.enums.LikeType
import com.umpa.core.domain.like.Like
import java.time.LocalDateTime

class LikeBuilder(
    val id: Long = 0L,
    val createdAt: LocalDateTime = LocalDateTime.now(),
    val updatedAt: LocalDateTime = LocalDateTime.now(),
    val userId: Long = 0L,
    val contentId: Long = 0L,
    val likeType: LikeType = LikeType.PLAYLIST,
    val isLike: Boolean = true
) {
    fun build(): Like {
        return Like(
            id = id,
            createdAt = createdAt,
            updatedAt = updatedAt,
            userId = userId,
            contentId = contentId,
            likeType = likeType,
            isLike = isLike
        )
    }
}
