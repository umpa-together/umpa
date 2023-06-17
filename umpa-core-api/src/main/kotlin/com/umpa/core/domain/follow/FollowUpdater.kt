package com.umpa.core.domain.follow

import com.umpa.storage.db.core.follow.FollowRepository
import jakarta.transaction.Transactional
import org.springframework.stereotype.Component

@Component
class FollowUpdater(
    private val followRepository: FollowRepository
) {
    @Transactional
    fun unfollow(followShip: FollowShip) {
        followRepository.findByFollowingUserIdAndFollowerUserIdAndActiveIsTrue(
            followingUserId = followShip.followingUserId,
            followerUserId = followShip.followerUserId
        )?.let {
            it.unfollow()
        }
    }
}
