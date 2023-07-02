package com.umpa.core.domain.content.playlist

import com.umpa.core.support.exceptions.CoreApiException
import com.umpa.core.support.exceptions.ErrorType
import org.springframework.stereotype.Service

@Service
class PlaylistDeleteService(
    private val playlistReader: PlaylistReader,
    private val playlistDeleter: PlaylistDeleterWrapper
) {
    fun delete(playlistId: Long, userId: Long) {
        val playlist = playlistReader.readById(playlistId)
        if (canDelete(playlist, userId)) {
            playlistDeleter.delete(playlistId)
        } else {
            throw CoreApiException(ErrorType.FORBIDDEN_DELETE_PLAYLIST)
        }
    }

    private fun canDelete(playlist: Playlist, userId: Long): Boolean {
        return !playlist.isNotMyPlaylist(userId)
    }
}
