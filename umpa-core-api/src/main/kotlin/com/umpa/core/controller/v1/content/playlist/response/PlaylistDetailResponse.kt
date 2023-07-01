package com.umpa.core.controller.v1.content.playlist.response

import com.umpa.core.controller.v1.comment.response.CommentDetailResponse
import com.umpa.core.controller.v1.user.response.PostUserResponse
import com.umpa.core.domain.content.playlist.PlaylistDetail
import com.umpa.core.domain.song.spotify.Track
import java.time.LocalDateTime

data class PlaylistDetailResponse(
    val playlistId: Long,
    val createdAt: LocalDateTime,
    val postUser: PostUserResponse,
    val title: String,
    val content: String,
    var imageUrl: String?,
    val youtubeUrl: String?,
    val viewCount: Long,
    val isDeleted: Boolean,
    val songs: List<Track>,
    val hashtags: List<String>,
    val comments: List<CommentDetailResponse>
) {
    companion object {
        fun fromPlaylistDetail(detail: PlaylistDetail): PlaylistDetailResponse {
            return PlaylistDetailResponse(
                playlistId = detail.playlist.id,
                createdAt = detail.playlist.createdAt,
                postUser = PostUserResponse.fromUserProfile(detail.postUser.userProfile()),
                title = detail.playlist.title,
                content = detail.playlist.content,
                imageUrl = detail.playlist.imageUrl,
                youtubeUrl = detail.playlist.youtubeUrl,
                viewCount = detail.playlist.viewCount,
                isDeleted = detail.playlist.isDeleted,
                songs = detail.songs,
                hashtags = detail.hashtags,
                comments = detail.comments.map { CommentDetailResponse.fromCommentDetail(it) }
            )
        }
    }
}
