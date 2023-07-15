package com.umpa.core.controller.v1.user.response

import com.umpa.core.domain.content.UserContentDetail
import com.umpa.core.domain.content.playlist.UserPlaylistDetail
import com.umpa.core.domain.song.spotify.Track
import java.time.LocalDateTime

data class UserContentDetailResponse(
    val playlists: List<UserPlaylistDetailResponse>
) {
    data class UserPlaylistDetailResponse(
        val id: Long,
        val title: String,
        val hasImage: Boolean,
        val imageUrl: String?,
        val trackImages: List<String>,
        val createdAt: LocalDateTime,
        val viewCount: Long,
        val representSong: Track,
        val songCount: Int
    ) {
        constructor(detail: UserPlaylistDetail) : this(
            id = detail.id,
            title = detail.title,
            hasImage = detail.hasImage,
            imageUrl = detail.imageUrl,
            trackImages = detail.trackImages,
            createdAt = detail.createdAt,
            viewCount = detail.viewCount,
            representSong = detail.representSong,
            songCount = detail.songCount
        )
    }

    constructor(detail: UserContentDetail) : this(
        playlists = detail.playlists.map { UserPlaylistDetailResponse(it) }
    )
}
