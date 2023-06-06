package com.umpa.core.domain.song

import com.umpa.storage.db.core.song.SongRepository
import org.springframework.stereotype.Component

@Component
class SongCreator(
    private val repository: SongRepository
) {
    fun create(creations: List<SongCreation>) {
        repository.saveAll(creations.map { it.toEntity() })
    }
}
