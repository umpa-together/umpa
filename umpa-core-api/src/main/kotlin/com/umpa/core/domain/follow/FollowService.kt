package com.umpa.core.domain.follow

import org.springframework.stereotype.Service

@Service
class FollowService(
    private val followValidator: FollowValidator,
    private val followCreator: FollowCreator,
    private val followUpdater: FollowUpdater
) {
    fun follow(followShip: FollowShip) {
        followValidator.validateFollow(followShip)
        followCreator.create(followShip)
    }

    fun unfollow(followShip: FollowShip) {
        followValidator.validateUnFollow(followShip)
        followUpdater.unfollow(followShip)
    }
}
