package com.umpa.core.domain.song.spotify

import com.umpa.client.spotify.response.ImageResponse

data class AlbumImage(
    val url: String,
    val height: Int,
    val width: Int
) {
    companion object {
        fun fromImageResponse(response: ImageResponse): AlbumImage {
            return AlbumImage(
                url = response.url,
                height = response.height ?: 640,
                width = response.width ?: 640
            )
        }
    }
}
