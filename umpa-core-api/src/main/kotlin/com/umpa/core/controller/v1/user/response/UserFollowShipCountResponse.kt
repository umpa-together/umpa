package com.umpa.core.controller.v1.user.response

import com.umpa.core.domain.follow.FollowingAndFollower

data class UserFollowShipCountResponse(
    val followingUserCount: Int,
    val followerUserCount: Int
) {
    constructor(followingAndFollower: FollowingAndFollower) : this(
        followingUserCount = followingAndFollower.followingUserIds.size,
        followerUserCount = followingAndFollower.followerUserIds.size
    )
}
