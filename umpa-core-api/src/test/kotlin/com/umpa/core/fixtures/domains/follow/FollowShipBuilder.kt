package com.umpa.core.fixtures.domains.follow

import com.umpa.core.domain.follow.FollowShip

class FollowShipBuilder(
    val followingUserId: Long = 0L,
    val followerUserId: Long = 1L
) {
    fun build(): FollowShip {
        return FollowShip(
            followingUserId = followingUserId,
            followerUserId = followerUserId
        )
    }
}
