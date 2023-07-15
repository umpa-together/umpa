package com.umpa.core.domain.follow

import com.umpa.storage.db.core.follow.FollowRepository
import org.springframework.stereotype.Component

@Component
class FollowReader(
    private val followRepository: FollowRepository
) {
    fun readFollowShipCountByUserId(userId: Long): FollowShipCount {
        val followingUserCount = followRepository.countByFollowingUserIdAndActiveIsTrue(userId)
        val followerUserCount = followRepository.countByFollowerUserIdAndActiveIsTrue(userId)
        return FollowShipCount(
            followingUserCount = followingUserCount,
            followerUserCount = followerUserCount
        )
    }
}
