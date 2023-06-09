package com.umpa.core.domain.comment

import com.umpa.core.support.exceptions.CoreApiException
import com.umpa.core.support.exceptions.ErrorType

data class CommentRemoval(
    val contentId: Long,
    val commentId: Long,
    val userId: Long
) {
    fun validate(comment: Comment) {
        if (contentId != comment.contentId) {
            throw CoreApiException(ErrorType.FORBIDDEN_CONTENT_ID)
        }
        if (userId != comment.userId) {
            throw CoreApiException(ErrorType.FORBIDDEN_USER_ID)
        }
    }
}
