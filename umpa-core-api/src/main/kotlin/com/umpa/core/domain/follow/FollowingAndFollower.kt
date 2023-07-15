package com.umpa.core.domain.follow

data class FollowingAndFollower(
    val followingUserIds: List<Long>,
    val followerUserIds: List<Long>
)
