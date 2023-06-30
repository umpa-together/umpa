package com.umpa.core.fixtures.domains.content.playlist

import com.umpa.core.domain.content.playlist.Playlist
import java.time.LocalDateTime

class PlaylistBuilder(
    val id: Long = 0L,
    val createdAt: LocalDateTime = LocalDateTime.now(),
    val updatedAt: LocalDateTime = LocalDateTime.now(),
    val userId: Long = 0L,
    val title: String = "",
    val content: String = "",
    val imageUrl: String? = null,
    val youtubeUrl: String? = null,
    val accessedAt: LocalDateTime = LocalDateTime.now(),
    val viewCount: Long = 0L,
    val isDeleted: Boolean = false
) {
    fun build(): Playlist {
        return Playlist(
            id = id,
            createdAt = createdAt,
            updatedAt = updatedAt,
            userId = userId,
            title = title,
            content = content,
            imageUrl = imageUrl,
            youtubeUrl = youtubeUrl,
            accessedAt = accessedAt,
            viewCount = viewCount,
            isDeleted = isDeleted,
        )
    }
}
