package com.umpa.core.controller.v1.spotiffy.request

import com.umpa.core.domain.song.spotify.AlbumImage

data class AlbumImageRequest(
    val url: String,
    val height: Int,
    val width: Int
) {
    fun toDomain(): AlbumImage {
        return AlbumImage(
            url = url,
            height = height,
            width = width
        )
    }
}
