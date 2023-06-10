package com.umpa.core.controller.v1.comment.request

import com.umpa.commons.enums.ContentType
import com.umpa.core.domain.comment.CommentCreation

data class CreateCommentRequest(
    val comment: String,
    val contentType: ContentType
) {
    fun toDomain(userId: Long, contentId: Long, parentCommentId: Long? = null): CommentCreation {
        return CommentCreation(
            contentId = contentId,
            userId = userId,
            comment = comment,
            parentCommentId = parentCommentId,
            contentType = contentType
        )
    }
}
