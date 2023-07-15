package com.umpa.core.domain.follow

import com.umpa.storage.db.core.follow.FollowRepository
import org.springframework.stereotype.Component

@Component
class FollowReader(
    private val followRepository: FollowRepository
) {
    fun readFollowShipCountByUserId(userId: Long): FollowingAndFollower {
        val followingUser = followRepository.findByFollowingUserIdAndActiveIsTrue(userId)
        val followerUser = followRepository.findByFollowerUserIdAndActiveIsTrue(userId)
        return FollowingAndFollower(
            followingUserIds = followingUser.map { it.followerUserId },
            followerUserIds = followerUser.map { it.followingUserId }
        )
    }
}
