package com.umpa.core.domain.like

import com.umpa.storage.db.core.like.LikeEntity
import com.umpa.storage.db.core.like.LikeRepository
import org.springframework.stereotype.Component

@Component
class LikeCreator(
    private val likeRepository: LikeRepository
) {
    fun create(creation: LikeCreation): LikeEntity {
        return likeRepository.save(creation.toEntity())
    }
}
