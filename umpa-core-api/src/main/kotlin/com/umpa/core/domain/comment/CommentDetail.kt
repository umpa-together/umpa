package com.umpa.core.domain.comment

import com.umpa.core.domain.user.User
import com.umpa.core.domain.user.UserProfile
import java.time.LocalDateTime

data class CommentDetail(
    override val id: Long,
    override val createdAt: LocalDateTime,
    override val comment: String,
    override val userProfile: UserProfile,
    var reComments: List<ReCommentDetail> = emptyList()
) : EachComment {
    companion object {
        fun fromComment(comment: Comment, users: List<User>): CommentDetail {
            val commentPostUser = users.find { it.id == comment.userId }!!
            return CommentDetail(
                id = comment.id,
                createdAt = comment.createdAt,
                comment = comment.comment,
                userProfile = UserProfile.fromUser(commentPostUser)
            )
        }
    }

    fun updateReComments(reComments: List<ReCommentDetail>) {
        this.reComments = reComments
    }
}
