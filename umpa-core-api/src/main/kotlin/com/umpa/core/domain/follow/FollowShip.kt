package com.umpa.core.domain.follow

import com.umpa.storage.db.core.follow.FollowEntity

data class FollowShip(
    val followingUserId: Long,
    val followerUserId: Long
) {
    fun toEntity(): FollowEntity {
        return FollowEntity(
            followingUserId = followingUserId,
            followerUserId = followerUserId
        )
    }
}
