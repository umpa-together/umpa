package com.umpa.core.controller.v1.content.daily.response

import com.umpa.core.controller.v1.comment.response.CommentDetailResponse
import com.umpa.core.controller.v1.user.response.PostUserResponse
import com.umpa.core.domain.content.daily.DailyDetail
import com.umpa.core.domain.song.spotify.Track
import java.time.LocalDateTime

data class DailyDetailResponse(
    val dailyId: Long,
    val createdAt: LocalDateTime,
    val postUser: PostUserResponse,
    val content: String,
    val imageUrls: List<String>?,
    val viewCount: Long,
    val isDeleted: Boolean,
    val songs: List<Track>,
    val hashtags: List<String>,
    val comments: List<CommentDetailResponse>
) {
    constructor(detail: DailyDetail) : this(
        dailyId = detail.daily.id,
        createdAt = detail.daily.createdAt,
        postUser = PostUserResponse.fromUserProfile(detail.postUser.profile()),
        content = detail.daily.content,
        imageUrls = detail.daily.imageUrls,
        viewCount = detail.daily.viewCount,
        isDeleted = detail.daily.isDeleted,
        songs = detail.songs,
        hashtags = detail.hashtags,
        comments = detail.comments.map { CommentDetailResponse.fromCommentDetail(it) }
    )
}
