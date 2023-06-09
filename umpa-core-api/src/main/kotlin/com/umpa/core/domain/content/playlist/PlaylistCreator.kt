package com.umpa.core.domain.content.playlist

import com.umpa.storage.db.core.playlist.PlaylistEntity
import com.umpa.storage.db.core.playlist.PlaylistRepository
import org.springframework.stereotype.Component

@Component
class PlaylistCreator(
    private val repository: PlaylistRepository
) {
    fun create(creation: PlaylistCreation): PlaylistEntity {
        return repository.save(
            creation.toEntity()
        )
    }
}
