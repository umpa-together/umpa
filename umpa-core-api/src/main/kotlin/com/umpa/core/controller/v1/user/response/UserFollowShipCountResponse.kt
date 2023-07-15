package com.umpa.core.controller.v1.user.response

import com.umpa.core.domain.follow.FollowShipCount

data class UserFollowShipCountResponse(
    val followingUserCount: Long,
    val followerUserCount: Long
) {
    constructor(count: FollowShipCount) : this(
        followingUserCount = count.followingUserCount,
        followerUserCount = count.followerUserCount
    )
}
