package com.umpa.core.fixtures.domains.content.playlist

import com.umpa.core.domain.comment.CommentDetail
import com.umpa.core.domain.content.playlist.Playlist
import com.umpa.core.domain.content.playlist.PlaylistDetail
import com.umpa.core.domain.song.spotify.Track
import com.umpa.core.domain.user.User
import com.umpa.core.fixtures.domains.user.UserBuilder

class PlaylistDetailBuilder(
    val playlist: Playlist = PlaylistBuilder().build(),
    val postUser: User = UserBuilder().build(),
    val songs: List<Track> = emptyList(),
    val hashtags: List<String> = emptyList(),
    val comments: List<CommentDetail> = emptyList()
) {
    fun build(): PlaylistDetail {
        return PlaylistDetail(
            playlist = playlist,
            postUser = postUser,
            songs = songs,
            hashtags = hashtags,
            comments = comments
        )
    }
}
