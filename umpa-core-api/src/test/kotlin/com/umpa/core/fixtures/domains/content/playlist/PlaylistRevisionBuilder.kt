package com.umpa.core.fixtures.domains.content.playlist

import com.umpa.core.domain.content.playlist.PlaylistRevision
import com.umpa.core.domain.song.spotify.Track

class PlaylistRevisionBuilder(
    val id: Long = 0L,
    val userId: Long = 0L,
    val title: String = "",
    val content: String = "",
    val songs: List<Track> = emptyList(),
    val hashtags: List<String> = emptyList()
) {
    fun build(): PlaylistRevision {
        return PlaylistRevision(
            id = id,
            userId = userId,
            title = title,
            content = content,
            songs = songs,
            hashtags = hashtags
        )
    }
}
