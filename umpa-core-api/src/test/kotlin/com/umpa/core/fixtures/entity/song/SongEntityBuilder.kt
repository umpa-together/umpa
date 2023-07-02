package com.umpa.core.fixtures.entity.song

import com.umpa.commons.enums.ContentType
import com.umpa.storage.db.core.song.SongEntity

class SongEntityBuilder(
    val uploadUserId: Long = 0L,
    val contentId: Long = 0L,
    val spotifyTrackId: String = "",
    val name: String = "",
    val artistNames: List<String> = emptyList(),
    val albumImage: String = "",
    val isExplicit: Boolean = false,
    val previewUrl: String? = null,
    val contentType: ContentType = ContentType.PLAYLIST,
    val isDeleted: Boolean = false
) {
    fun build(): SongEntity {
        return SongEntity(
            uploadUserId = uploadUserId,
            contentId = contentId,
            spotifyTrackId = spotifyTrackId,
            name = name,
            artistNames = artistNames,
            albumImage = albumImage,
            isExplicit = isExplicit,
            previewUrl = previewUrl,
            contentType = contentType,
            isDeleted = isDeleted
        )
    }
}
