package com.umpa.storage.db.core.follow

import com.umpa.storage.db.core.BaseEntity
import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.Table

@Table
@Entity(name = "follow")
class FollowEntity(
    @Column(name = "ref_following_user_id")
    val followingUserId: Long,

    @Column(name = "ref_follower_user_id")
    val followerUserId: Long,

    @Column(name = "active")
    var active: Boolean = true
) : BaseEntity() {
    fun unfollow() {
        this.active = false
    }
}
