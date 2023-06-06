package com.umpa.core.domain.song

import com.umpa.ContentType
import com.umpa.core.domain.song.spotify.AlbumImage
import com.umpa.song.SongEntity

data class SongCreation(
    val uploadUserId: Long,
    val contentId: Long,
    val id: String,
    val name: String,
    val artistNames: List<String>,
    val albumImage: AlbumImage,
    val isExplicit: Boolean,
    val previewUrl: String?,
    val contentType: ContentType
) {
    fun toEntity(): SongEntity {
        return SongEntity(
            contentId = contentId,
            uploadUserId = uploadUserId,
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
