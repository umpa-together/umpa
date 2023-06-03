package com.umpa.core.domain.content.playlist

import com.umpa.playlist.PlaylistEntity
import java.time.LocalDateTime

data class Playlist(
    val id: Long,
    val createdAt: LocalDateTime?,
    val updatedAt: LocalDateTime?,
    val userId: Long,
    val title: String,
    val content: String,
    var imageUrl: String?,
    val youtubeUrl: String?,
    val accessedAt: LocalDateTime,
    val viewCount: Long,
    val isDeleted: Boolean
) {
    companion object {
        fun fromEntity(entity: PlaylistEntity): Playlist {
            return Playlist(
                id = entity.id,
                createdAt = entity.createdAt,
                updatedAt = entity.updatedAt,
                userId = entity.userId,
                title = entity.title,
                content = entity.content,
                imageUrl = entity.imageUrl,
                youtubeUrl = entity.youtubeUrl,
                accessedAt = entity.accessedAt,
                viewCount = entity.viewCount,
                isDeleted = entity.isDeleted
            )
        }
    }
}
