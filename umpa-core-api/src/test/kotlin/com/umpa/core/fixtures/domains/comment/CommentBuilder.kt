package com.umpa.core.fixtures.domains.comment

import com.umpa.commons.enums.ContentType
import com.umpa.core.domain.comment.Comment
import java.time.LocalDateTime

class CommentBuilder(
    val id: Long = 0L,
    val createdAt: LocalDateTime = LocalDateTime.now(),
    val updatedAt: LocalDateTime = LocalDateTime.now(),
    val contentId: Long = 0L,
    val userId: Long = 0L,
    val comment: String = "",
    val parentCommentId: Long? = null,
    val contentType: ContentType = ContentType.PLAYLIST,
    val isDeleted: Boolean = false
) {
    fun build(): Comment {
        return Comment(
            id = id,
            createdAt = createdAt,
            updatedAt = updatedAt,
            contentId = contentId,
            userId = userId,
            comment = comment,
            parentCommentId = parentCommentId,
            contentType = contentType,
            isDeleted = isDeleted,
        )
    }
}
