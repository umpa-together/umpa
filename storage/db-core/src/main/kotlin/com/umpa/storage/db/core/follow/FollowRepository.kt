package com.umpa.storage.db.core.follow

import org.springframework.data.jpa.repository.JpaRepository

interface FollowRepository : JpaRepository<FollowEntity, Long> {
    fun existsByFollowingUserIdAndFollowerUserIdAndActive(followingUserId: Long, followerUserId: Long, active: Boolean): Boolean

    fun findByFollowingUserIdAndFollowerUserIdAndActiveIsTrue(followingUserId: Long, followerUserId: Long): FollowEntity?
}
