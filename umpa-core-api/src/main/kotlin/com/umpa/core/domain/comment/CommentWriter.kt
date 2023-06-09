package com.umpa.core.domain.comment

import com.umpa.core.support.exceptions.CoreApiException
import com.umpa.core.support.exceptions.ErrorType
import com.umpa.storage.db.core.comment.CommentRepository
import jakarta.transaction.Transactional
import org.springframework.stereotype.Component

@Component
class CommentWriter(
    private val commentRepository: CommentRepository
) {
    fun write(creation: CommentCreation) {
        commentRepository.save(creation.toEntity())
    }

    @Transactional
    fun deleteByContentId(contentId: Long) {
        commentRepository.readByContentId(contentId)?.apply {
            this.isDeleted = true
        } ?: throw CoreApiException(ErrorType.NOT_FOUND_COMMENT)
    }
}
