package com.umpa.core.domain.like

import com.umpa.commons.enums.LikeType
import com.umpa.core.support.exceptions.CoreApiException
import com.umpa.core.support.exceptions.ErrorType
import com.umpa.storage.db.core.like.LikeEntity
import java.time.LocalDateTime

data class Like(
    val id: Long,
    val createdAt: LocalDateTime,
    val updatedAt: LocalDateTime,
    val userId: Long,
    val contentId: Long,
    val likeType: LikeType,
    val isLike: Boolean
) {
    companion object {
        fun fromEntity(entity: LikeEntity): Like {
            return Like(
                id = entity.id,
                createdAt = entity.createdAt,
                updatedAt = entity.updatedAt,
                userId = entity.userId,
                contentId = entity.contentId,
                likeType = entity.likeType,
                isLike = entity.isLike
            )
        }
    }

    fun validate(userId: Long) {
        if (this.userId != userId) {
            throw CoreApiException(ErrorType.FORBIDDEN_UNLIKE)
        }
    }
}
