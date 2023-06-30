package com.umpa.core.domain.comment

import com.umpa.commons.enums.ContentType
import com.umpa.storage.db.core.comment.CommentEntity
import java.time.LocalDateTime

data class Comment(
    val id: Long,
    val createdAt: LocalDateTime,
    val updatedAt: LocalDateTime,
    val contentId: Long,
    val userId: Long,
    val comment: String,
    val parentCommentId: Long?,
    val contentType: ContentType,
    val isDeleted: Boolean
) {
    companion object {
        fun fromEntity(entity: CommentEntity): Comment {
            return Comment(
                id = entity.id,
                createdAt = entity.createdAt,
                updatedAt = entity.updatedAt,
                contentId = entity.contentId,
                userId = entity.userId,
                comment = entity.comment,
                parentCommentId = entity.parentCommentId,
                contentType = entity.contentType,
                isDeleted = entity.isDeleted
            )
        }
    }

    fun isParentComment(): Boolean {
        return parentCommentId == null
    }

    fun isReComment(): Boolean {
        return parentCommentId != null
    }
}
