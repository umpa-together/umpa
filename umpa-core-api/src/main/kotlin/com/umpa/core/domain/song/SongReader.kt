package com.umpa.core.domain.song

import com.umpa.core.domain.song.spotify.Track
import com.umpa.storage.db.core.song.SongRepository
import org.springframework.stereotype.Component

@Component
class SongReader(
    private val songRepository: SongRepository
) {
    fun readByContentId(contentId: Long): List<Track> {
        return songRepository.findAllByContentIdAndIsDeletedIsFalse(contentId)
            .map { Track.fromEntity(it) }
    }
}
