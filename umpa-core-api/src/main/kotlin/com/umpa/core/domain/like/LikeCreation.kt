package com.umpa.core.domain.like

import com.umpa.commons.enums.LikeType
import com.umpa.storage.db.core.like.LikeEntity

data class LikeCreation(
    val userId: Long,
    val contentId: Long,
    val likeType: LikeType
) {
    fun toEntity(): LikeEntity {
        return LikeEntity(
            userId = userId,
            contentId = contentId,
            likeType = likeType
        )
    }
}
