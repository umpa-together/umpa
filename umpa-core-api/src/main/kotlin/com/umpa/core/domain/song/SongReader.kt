package com.umpa.core.domain.song

import com.umpa.commons.enums.ContentType
import com.umpa.core.domain.song.spotify.Track
import com.umpa.storage.db.core.song.SongEntity
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

    fun readByUserId(userId: Long): List<Track> {
        return songRepository.findAllByUserIdAndIsDeletedIsFalse(userId)
            .map { Track.fromEntity(it) }
    }

    fun readByContentIdInAndContentType(contentIds: List<Long>, contentType: ContentType): List<SongEntity> {
        return songRepository.findAllByContentIdInAndContentTypeAndIsDeletedIsFalse(contentIds, contentType)
    }
}
