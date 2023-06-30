package com.umpa.core.controller.v1.comment.response

import com.umpa.core.controller.v1.user.response.PostUserResponse
import com.umpa.core.domain.comment.CommentDetail
import java.time.LocalDateTime

data class CommentDetailResponse(
    val id: Long,
    val createdAt: LocalDateTime,
    val comment: String,
    val postUser: PostUserResponse,
    val reComments: List<ReCommentDetailResponse>
) {
    companion object {
        fun fromCommentDetail(detail: CommentDetail): CommentDetailResponse {
            return CommentDetailResponse(
                id = detail.id,
                createdAt = detail.createdAt,
                comment = detail.comment,
                postUser = PostUserResponse.fromUserProfile(detail.userProfile),
                reComments = detail.reComments.map { ReCommentDetailResponse.fromReCommentDetail(it) }
            )
        }
    }
}
