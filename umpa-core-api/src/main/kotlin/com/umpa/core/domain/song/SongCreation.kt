package com.umpa.core.domain.song

import com.umpa.commons.enums.ContentType
import com.umpa.core.domain.song.spotify.AlbumImage
import com.umpa.storage.db.core.song.SongEntity

data class SongCreation(
    val userId: Long,
    val contentId: Long? = null,
    val id: String,
    val name: String,
    val artistNames: List<String>,
    val albumImage: AlbumImage,
    val isExplicit: Boolean,
    val previewUrl: String?,
    val contentType: ContentType? = null
) {
    fun toEntity(): SongEntity {
        return SongEntity(
            contentId = contentId,
            userId = userId,
            spotifyTrackId = id,
            name = name,
            artistNames = artistNames,
            albumImage = albumImage.url,
            isExplicit = isExplicit,
            previewUrl = previewUrl,
            contentType = contentType
        )
    }
}
