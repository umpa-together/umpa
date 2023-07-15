package com.umpa.core.domain.follow

import com.umpa.storage.db.core.follow.FollowRepository
import org.springframework.stereotype.Component

@Component
class FollowCreator(
    private val followRepository: FollowRepository
) {
    fun create(followShip: FollowShip) {
        followRepository.save(followShip.toEntity())
    }
}
