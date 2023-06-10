package com.umpa.core.domain.comment

import com.umpa.storage.db.core.comment.CommentRepository
import org.springframework.stereotype.Component

@Component
class CommentCreator(
    private val commentRepository: CommentRepository
) {
    fun create(creation: CommentCreation) {
        commentRepository.save(creation.toEntity())
    }
}
