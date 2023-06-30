package com.umpa.core.domain.comment

import com.umpa.core.domain.user.UserReader
import org.springframework.stereotype.Component

@Component
class CommentDetailGetter(
    private val commentReader: CommentReader,
    private val userReader: UserReader
) {
    fun get(contentId: Long): List<CommentDetail> {
        val comments = commentReader.readByContentId(contentId)
        val userIds = comments.map { it.userId }
        val users = userReader.readByIdIn(userIds)
        return CommentDetailBuilder.build(allComments = comments, users = users)
    }
}
