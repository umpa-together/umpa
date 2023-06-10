package com.umpa.core.domain.comment

import com.umpa.commons.enums.ContentType
import com.umpa.storage.db.core.comment.CommentEntity

data class CommentCreation(
    val contentId: Long,
    val userId: Long,
    val comment: String,
    val parentCommentId: Long?,
    val contentType: ContentType
) {
    fun toEntity(): CommentEntity {
        return CommentEntity(
            contentId = contentId,
            userId = userId,
            comment = comment,
            parentCommentId = parentCommentId,
            contentType = contentType
        )
    }
}
