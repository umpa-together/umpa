package com.umpa.core.domain.comment

import com.umpa.core.domain.user.User
import com.umpa.core.domain.user.UserProfile
import java.time.LocalDateTime

data class ReCommentDetail(
    override val id: Long,
    override val createdAt: LocalDateTime,
    override val comment: String,
    override val userProfile: UserProfile,
    val parentCommentId: Long
) : EachComment {
    companion object {
        fun fromComment(comment: Comment, users: List<User>): ReCommentDetail {
            val commentPostUser = users.find { it.id == comment.userId }!!
            return ReCommentDetail(
                id = comment.id,
                createdAt = comment.createdAt,
                comment = comment.comment,
                userProfile = UserProfile.fromUser(commentPostUser),
                parentCommentId = comment.parentCommentId!!
            )
        }
    }
}
