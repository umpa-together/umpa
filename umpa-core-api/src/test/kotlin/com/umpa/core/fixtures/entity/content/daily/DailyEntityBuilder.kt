package com.umpa.core.fixtures.entity.content.daily

import com.umpa.storage.db.core.daily.DailyEntity
import java.time.LocalDateTime

class DailyEntityBuilder(
    val userId: Long = 0L,
    val content: String = "",
    val imageUrls: List<String>? = null,
    val accessedAt: LocalDateTime = LocalDateTime.now(),
    val viewCount: Long = 0L,
    val isDeleted: Boolean = false
) {
    fun build(): DailyEntity {
        return DailyEntity(
            userId = userId,
            content = content,
            imageUrls = imageUrls,
            accessedAt = accessedAt,
            viewCount = viewCount,
            isDeleted = isDeleted
        )
    }
}
