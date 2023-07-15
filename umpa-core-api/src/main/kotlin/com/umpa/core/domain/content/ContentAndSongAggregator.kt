package com.umpa.core.domain.content

import com.umpa.core.domain.content.playlist.Playlist
import com.umpa.core.domain.content.playlist.UserPlaylistDetail
import com.umpa.core.domain.song.spotify.Track
import com.umpa.storage.db.core.song.SongEntity

object ContentAndSongAggregator {
    fun aggregate(playlists: List<Playlist>, songs: List<SongEntity>): List<UserPlaylistDetail> {
        return playlists.map {
            val tracks = getTracks(it.id, songs)
            UserPlaylistDetail(
                id = it.id,
                title = it.title,
                hasImage = it.hasThumbnail(),
                imageUrl = it.imageUrl,
                trackImages = tracks.map { track -> track.albumImage.url },
                createdAt = it.createdAt,
                viewCount = it.viewCount,
                representSong = tracks[0],
                songCount = tracks.size
            )
        }
    }

    private fun getTracks(contentId: Long, songs: List<SongEntity>): List<Track> {
        return songs.filter { it.contentId!! == contentId }
            .map { Track.fromEntity(it) }
    }
}
