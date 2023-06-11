package com.umpa.core.fixtures.domains.comment

import com.umpa.core.domain.comment.CommentRemoval

class CommentRemovalBuilder(
    val contentId: Long = 0L,
    val commentId: Long = 0L,
    val parentCommentId: Long? = null,
    val userId: Long = 0L
) {
    fun build(): CommentRemoval {
        return CommentRemoval(
            contentId = contentId,
            commentId = commentId,
            parentCommentId = parentCommentId,
            userId = userId
        )
    }
}
