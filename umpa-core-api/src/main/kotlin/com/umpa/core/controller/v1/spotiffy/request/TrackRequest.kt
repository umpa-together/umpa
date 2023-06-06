package com.umpa.core.controller.v1.spotiffy.request

import com.umpa.core.domain.song.spotify.Track

data class TrackRequest(
    val id: String,
    val name: String,
    val artistNames: List<String>,
    val albumImage: AlbumImageRequest,
    val isExplicit: Boolean,
    val previewUrl: String?
) {
    fun toDomain(): Track {
        return Track(
            id = id,
            name = name,
            artistNames = artistNames,
            albumImage = albumImage.toDomain(),
            isExplicit = isExplicit,
            previewUrl = previewUrl
        )
    }
}
