package com.umpa.core.domain.like

import org.springframework.stereotype.Service

@Service
class LikeService(
    private val likeCreator: LikeCreator,
    private val likeReader: LikeReader,
    private val likeUpdater: LikeUpdater
) {
    fun like(creation: LikeCreation) {
        likeCreator.create(creation)
        // TODO notification + 푸쉬 알림
    }

    fun unlike(id: Long, userId: Long) {
        val like = likeReader.readById(id).let { Like.fromEntity(it) }
        like.validate(userId)
        likeUpdater.updateUnlike(id)
        // TODO notification active = false
    }
}
