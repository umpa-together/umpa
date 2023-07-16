package com.umpa.core.domain.content.daily

import com.umpa.storage.db.core.daily.DailyEntity
import java.time.LocalDateTime

data class Daily(
    val id: Long,
    val createdAt: LocalDateTime,
    val updatedAt: LocalDateTime,
    val userId: Long,
    val content: String,
    val imageUrls: List<String>?,
    val accessedAt: LocalDateTime,
    val viewCount: Long,
    val isDeleted: Boolean
) {
    companion object {
        fun fromEntity(entity: DailyEntity): Daily {
            return Daily(
                id = entity.id,
                createdAt = entity.createdAt,
                updatedAt = entity.updatedAt,
                userId = entity.userId,
                content = entity.content,
                imageUrls = entity.imageUrls,
                accessedAt = entity.accessedAt,
                viewCount = entity.viewCount,
                isDeleted = entity.isDeleted
            )
        }
    }

    fun isNotMyDaily(userId: Long): Boolean {
        return this.userId != userId
    }
}
