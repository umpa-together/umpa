package com.umpa.core.domain.comment

import org.springframework.stereotype.Service

@Service
class CommentService(
    private val commentCreator: CommentCreator,
    private val commentReader: CommentReader,
    private val commentUpdater: CommentUpdater
) {
    fun create(creation: CommentCreation) {
        commentCreator.create(creation)
        // TODO notice 추가 + push notification
    }

    fun remove(removal: CommentRemoval) {
        val comment = commentReader.readById(removal.contentId)
        removal.validate(comment)
        commentUpdater.deleteByContentId(removal.commentId)
        // TODO notice도 delete
    }
}
