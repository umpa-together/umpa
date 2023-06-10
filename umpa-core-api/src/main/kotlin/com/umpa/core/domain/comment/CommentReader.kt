package com.umpa.core.domain.comment

import com.umpa.core.support.exceptions.CoreApiException
import com.umpa.core.support.exceptions.ErrorType
import com.umpa.storage.db.core.comment.CommentEntity
import com.umpa.storage.db.core.comment.CommentRepository
import org.springframework.stereotype.Component

@Component
class CommentReader(
    private val commentRepository: CommentRepository
) {
    fun readById(id: Long): CommentEntity {
        return commentRepository.readById(id)
            ?: throw CoreApiException(ErrorType.NOT_FOUND_COMMENT)
    }
}
