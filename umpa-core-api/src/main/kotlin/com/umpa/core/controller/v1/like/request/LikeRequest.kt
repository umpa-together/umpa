package com.umpa.core.controller.v1.like.request

import com.umpa.commons.enums.LikeType
import com.umpa.core.domain.like.LikeCreation

data class LikeRequest(
    val contentId: Long,
    val likeType: LikeType
) {
    fun toDomain(userId: Long): LikeCreation {
        return LikeCreation(
            userId = userId,
            contentId = contentId,
            likeType = likeType
        )
    }
}
