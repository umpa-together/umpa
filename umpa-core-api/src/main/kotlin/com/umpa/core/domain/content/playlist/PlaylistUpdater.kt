package com.umpa.core.domain.content.playlist

import com.umpa.core.support.exceptions.CoreApiException
import com.umpa.core.support.exceptions.ErrorType
import com.umpa.storage.db.core.playlist.PlaylistRepository
import jakarta.transaction.Transactional
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Component

@Component
class PlaylistUpdater(
    private val playlistRepository: PlaylistRepository
) {
    @Transactional
    fun increaseViewCount(id: Long) {
        playlistRepository.findByIdOrNull(id)?.apply { this.increaseViewCount() }
    }

    @Transactional
    fun edit(revision: PlaylistRevision): Playlist {
        return playlistRepository.findByIdOrNull(revision.id)
            ?.apply { this.editPlaylist(title = revision.title, content = revision.content) }
            ?.let { Playlist.fromEntity(it) }
            ?: throw CoreApiException(ErrorType.NOT_FOUND_PLAYLIST)
    }
}
