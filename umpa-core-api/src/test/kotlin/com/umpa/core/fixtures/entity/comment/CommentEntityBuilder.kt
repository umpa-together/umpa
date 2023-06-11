package com.umpa.core.fixtures.entity.comment

import com.umpa.commons.enums.ContentType
import com.umpa.storage.db.core.comment.CommentEntity

class CommentEntityBuilder(
    val contentId: Long = 0L,
    val userId: Long = 0L,
    val comment: String = "comment",
    val parentCommentId: Long? = null,
    val contentType: ContentType = ContentType.PLAYLIST,
    var isDeleted: Boolean = false
) {
    fun build(): CommentEntity {
        return CommentEntity(
            contentId = contentId,
            userId = userId,
            comment = comment,
            parentCommentId = parentCommentId,
            contentType = contentType,
            isDeleted = isDeleted
        )
    }
}
