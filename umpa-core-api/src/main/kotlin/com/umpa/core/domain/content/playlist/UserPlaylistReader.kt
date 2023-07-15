package com.umpa.core.domain.content.playlist

import com.umpa.commons.enums.ContentType
import com.umpa.core.domain.content.ContentAndSongAggregator
import com.umpa.core.domain.song.SongReader
import com.umpa.storage.db.core.playlist.PlaylistRepository
import org.springframework.stereotype.Component

@Component
class UserPlaylistReader(
    private val playlistRepository: PlaylistRepository,
    private val songReader: SongReader
) {
    fun readByUserId(userId: Long): List<UserPlaylistDetail> {
        val playlists = playlistRepository.findAllByUserIdAndIsDeletedIsFalse(userId)
            .map { Playlist.fromEntity(it) }
        val playlistIds = playlists.map { it.id }
        val songs = songReader.readByContentIdInAndContentType(playlistIds, ContentType.PLAYLIST)
        return ContentAndSongAggregator.aggregate(playlists, songs)
    }
}
