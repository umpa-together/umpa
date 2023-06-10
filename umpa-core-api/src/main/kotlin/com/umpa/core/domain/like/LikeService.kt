package com.umpa.core.domain.like

import org.springframework.stereotype.Service

@Service
class LikeService(
    private val likeCreator: LikeCreator
) {
    fun like(creation: LikeCreation) {
        likeCreator.create(creation)
        // TODO notification + 푸쉬 알림
    }
}
