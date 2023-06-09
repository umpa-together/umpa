package com.umpa.core.domain.comment

import com.umpa.core.support.exceptions.CoreApiException
import com.umpa.core.support.exceptions.ErrorType
import com.umpa.storage.db.core.comment.CommentRepository
import org.springframework.stereotype.Component

@Component
class CommentReader(
    private val commentRepository: CommentRepository
) {
    fun readByContentId(contentId: Long): Comment {
        return commentRepository.readByContentId(contentId)?.let {
            Comment.fromEntity(it)
        } ?: throw CoreApiException(ErrorType.NOT_FOUND_COMMENT)
    }
}
