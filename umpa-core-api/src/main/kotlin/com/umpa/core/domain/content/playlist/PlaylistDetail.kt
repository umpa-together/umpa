package com.umpa.core.domain.content.playlist

import com.umpa.core.domain.comment.CommentDetail
import com.umpa.core.domain.song.spotify.Track
import com.umpa.core.domain.user.User

data class PlaylistDetail(
    val playlist: Playlist,
    val postUser: User,
    val songs: List<Track>,
    val hashtags: List<String>,
    val comments: List<CommentDetail>
)
