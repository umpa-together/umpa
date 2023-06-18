package com.umpa.core.domain.content.playlist

import com.umpa.core.domain.song.SongReader
import com.umpa.core.support.exceptions.CoreApiException
import com.umpa.core.support.exceptions.ErrorType
import com.umpa.storage.db.core.playlist.PlaylistRepository
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Component

@Component
class PlaylistReader(
    private val playlistRepository: PlaylistRepository,
    private val songReader: SongReader
) {
    fun readById(id: Long): Playlist {
        return playlistRepository.findByIdOrNull(id)?.let {
            if (it.isDeleted) {
                throw CoreApiException(ErrorType.FORBIDDEN_DELETED_PLAYLIST)
            }
            Playlist.fromEntity(it)
        } ?: throw CoreApiException(ErrorType.NOT_FOUND_PLAYLIST)
    }

    fun readByUserId(userId: Long) {
        val playlists = playlistRepository.findAllByUserIdAndIsDeletedIsFalse(userId)
        val playlistIds = playlists.map { it.id }
        val songs = songReader.readPlaylistSongsByContentIdIn(playlistIds)

    }
}
