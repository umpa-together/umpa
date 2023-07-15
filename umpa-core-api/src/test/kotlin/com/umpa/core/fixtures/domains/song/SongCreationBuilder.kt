package com.umpa.core.fixtures.domains.song

import com.umpa.commons.enums.ContentType
import com.umpa.core.domain.song.SongCreation
import com.umpa.core.domain.song.spotify.AlbumImage

class SongCreationBuilder(
    val userId: Long = 0L,
    val contentId: Long = 0L,
    val id: String = "",
    val name: String = "",
    val artistNames: List<String> = emptyList(),
    val albumImage: AlbumImage = AlbumImage(""),
    val isExplicit: Boolean = false,
    val previewUrl: String? = "",
    val contentType: ContentType = ContentType.PLAYLIST
) {
    fun build(): SongCreation {
        return SongCreation(
            userId = userId,
            contentId = contentId,
            id = id,
            name = name,
            artistNames = artistNames,
            albumImage = albumImage,
            isExplicit = isExplicit,
            previewUrl = previewUrl,
            contentType = contentType
        )
    }
}
