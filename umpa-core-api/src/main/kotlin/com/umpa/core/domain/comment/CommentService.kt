package com.umpa.core.domain.comment

import org.springframework.stereotype.Service

@Service
class CommentService(
    private val commentWriter: CommentWriter
) {
    fun create(creation: CommentCreation) {
        commentWriter.write(creation)
        // TODO notice 추가 + push notification
    }
}
