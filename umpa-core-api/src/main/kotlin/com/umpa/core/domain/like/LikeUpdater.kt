package com.umpa.core.domain.like

import com.umpa.storage.db.core.like.LikeRepository
import jakarta.transaction.Transactional
import org.springframework.stereotype.Component

@Component
class LikeUpdater(
    private val likeRepository: LikeRepository
) {
    @Transactional
    fun updateUnlike(id: Long) {
        likeRepository.readById(id)!!.unLike()
    }
}
