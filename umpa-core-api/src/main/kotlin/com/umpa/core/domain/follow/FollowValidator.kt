package com.umpa.core.domain.follow

import com.umpa.core.support.exceptions.CoreApiException
import com.umpa.core.support.exceptions.ErrorType
import com.umpa.storage.db.core.follow.FollowRepository
import org.springframework.stereotype.Component

@Component
class FollowValidator(
    private val followRepository: FollowRepository
) {
    fun validateFollow(followShip: FollowShip) {
        val followShipIsExists = followRepository.existsByFollowingUserIdAndFollowerUserIdAndActive(
            followingUserId = followShip.followingUserId,
            followerUserId = followShip.followerUserId,
            active = true
        )
        if (followShipIsExists) {
            throw CoreApiException(ErrorType.FORBIDDEN_FOLLOW)
        }
    }

    fun validateUnFollow(followShip: FollowShip) {
        val followShipIsExists = followRepository.existsByFollowingUserIdAndFollowerUserIdAndActive(
            followingUserId = followShip.followingUserId,
            followerUserId = followShip.followerUserId,
            active = true
        )
        if (!followShipIsExists) {
            throw CoreApiException(ErrorType.FORBIDDEN_UNFOLLOW)
        }
    }
}
