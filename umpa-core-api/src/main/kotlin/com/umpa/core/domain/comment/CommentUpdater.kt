package com.umpa.core.domain.comment

import com.umpa.core.support.exceptions.CoreApiException
import com.umpa.core.support.exceptions.ErrorType
import com.umpa.storage.db.core.comment.CommentRepository
import jakarta.transaction.Transactional
import org.springframework.stereotype.Component

@Component
class CommentUpdater (
    private val commentRepository: CommentRepository
){
    @Transactional
    fun deleteByContentId(id: Long) {
        commentRepository.readById(id)?.apply {
            this.isDeleted = true
        } ?: throw CoreApiException(ErrorType.NOT_FOUND_COMMENT)
    }
}
