package com.umpa.core.domain.comment

import org.springframework.stereotype.Service

@Service
class CommentService(
    private val commentWriter: CommentWriter,
    private val commentReader: CommentReader
) {
    fun create(creation: CommentCreation) {
        commentWriter.write(creation)
        // TODO notice 추가 + push notification
    }

    fun remove(removal: CommentRemoval) {
        val comment = commentReader.readByContentId(removal.contentId)
        removal.validate(comment)
        commentWriter.deleteByContentId(removal.contentId)
        // TODO notice도 delete
    }
}
