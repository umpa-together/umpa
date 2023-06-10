package com.umpa.core.fixtures.entity.like

import com.umpa.commons.enums.LikeType
import com.umpa.storage.db.core.like.LikeEntity

class LikeEntityBuilder(
    val userId: Long = 0L,
    val contentId: Long = 0L,
    val likeType: LikeType = LikeType.PLAYLIST,
    var isLike: Boolean = true
) {
    fun build(): LikeEntity {
        return LikeEntity(
            userId = userId,
            contentId = contentId,
            likeType = likeType,
            isLike = isLike
        )
    }
}
