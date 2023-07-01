package com.umpa.core.controller.v1.comment.response

import com.umpa.core.controller.v1.user.response.PostUserResponse
import com.umpa.core.domain.comment.ReCommentDetail
import java.time.LocalDateTime

data class ReCommentDetailResponse(
    val id: Long,
    val createdAt: LocalDateTime,
    val comment: String,
    val postUser: PostUserResponse
) {
    companion object {
        fun fromReCommentDetail(detail: ReCommentDetail): ReCommentDetailResponse {
            return ReCommentDetailResponse(
                id = detail.id,
                createdAt = detail.createdAt,
                comment = detail.comment,
                postUser = PostUserResponse.fromUserProfile(detail.userProfile)
            )
        }
    }
}
