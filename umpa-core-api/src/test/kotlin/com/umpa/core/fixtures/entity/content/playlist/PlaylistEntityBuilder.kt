package com.umpa.core.fixtures.entity.content.playlist

import com.umpa.storage.db.core.playlist.PlaylistEntity
import java.time.LocalDateTime

class PlaylistEntityBuilder(
    val userId: Long = 0L,
    val title: String = "",
    val content: String = "",
    val imageUrl: String? = null,
    val youtubeUrl: String? = null,
    val accessedAt: LocalDateTime = LocalDateTime.now(),
    val viewCount: Long = 0L,
    val isDeleted: Boolean = false
) {
    fun build(): PlaylistEntity {
        return PlaylistEntity(
            userId = userId,
            title = title,
            content = content,
            imageUrl = imageUrl,
            youtubeUrl = youtubeUrl,
            accessedAt = accessedAt,
            viewCount = viewCount,
            isDeleted = isDeleted
        )
    }
}
