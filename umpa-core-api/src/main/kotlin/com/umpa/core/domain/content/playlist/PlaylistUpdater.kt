package com.umpa.core.domain.content.playlist

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
}
