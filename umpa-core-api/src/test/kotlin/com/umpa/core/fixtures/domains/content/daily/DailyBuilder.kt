package com.umpa.core.fixtures.domains.content.daily

import com.umpa.core.domain.content.daily.Daily
import java.time.LocalDateTime

class DailyBuilder(
    val id: Long = 0L,
    val createdAt: LocalDateTime = LocalDateTime.now(),
    val updatedAt: LocalDateTime = LocalDateTime.now(),
    val userId: Long = 0L,
    val content: String = "",
    val imageUrls: List<String>? = null,
    val accessedAt: LocalDateTime = LocalDateTime.now(),
    val viewCount: Long = 0L,
    val isDeleted: Boolean = false
) {
    fun build(): Daily {
        return Daily(
            id = id,
            createdAt = createdAt,
            updatedAt = updatedAt,
            userId = userId,
            content = content,
            imageUrls = imageUrls,
            accessedAt = accessedAt,
            viewCount = viewCount,
            isDeleted = isDeleted
        )
    }
}
