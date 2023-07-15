package com.umpa.core.controller.v1.user.request

import com.umpa.core.domain.follow.FollowShip

data class FollowShipRequest(
    val followingUserId: Long,
    val followerUserId: Long
) {
    fun toDomain(): FollowShip {
        return FollowShip(
            followingUserId = followingUserId,
            followerUserId = followerUserId
        )
    }
}
