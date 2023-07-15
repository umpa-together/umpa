package com.umpa.core.fixtures.domains.follow

import com.umpa.storage.db.core.follow.FollowEntity

class FollowEntityBuilder(
    val followingUserId: Long = 0L,
    val followerUserId: Long = 0L,
    val active: Boolean = true
) {
    fun build(): FollowEntity {
        return FollowEntity(
            followingUserId = followingUserId,
            followerUserId = followerUserId,
            active = active
        )
    }
}
