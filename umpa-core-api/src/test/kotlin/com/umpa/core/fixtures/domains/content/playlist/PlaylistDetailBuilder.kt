package com.umpa.core.fixtures.domains.content.playlist

import com.umpa.core.domain.comment.CommentDetail
import com.umpa.core.domain.content.playlist.Playlist
import com.umpa.core.domain.content.playlist.PlaylistDetail
import com.umpa.core.domain.song.spotify.Track

class PlaylistDetailBuilder(
    val playlist: Playlist = PlaylistBuilder().build(),
    val songs: List<Track> = emptyList(),
    val hashtags: List<String> = emptyList(),
    val comments: List<CommentDetail> = emptyList()
) {
    fun build(): PlaylistDetail {
        return PlaylistDetail(
            playlist = playlist,
            songs = songs,
            hashtags = hashtags,
            comments = comments,
        )
    }
}
