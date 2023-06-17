package com.umpa.core.controller.v1.user

import com.umpa.commons.api.response.CommonApiResponse
import com.umpa.core.controller.v1.user.request.EnrollSongsRequest
import com.umpa.core.controller.v1.user.request.FollowShipRequest
import com.umpa.core.domain.follow.FollowService
import com.umpa.core.domain.user.UserSongCreateService
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/v1/users")
class UserController(
    private val followService: FollowService,
    private val userSongCreateService: UserSongCreateService
) {
    @PostMapping("/follow")
    fun follow(
        @RequestBody body: FollowShipRequest
    ): CommonApiResponse<Nothing> {
        followService.follow(body.toDomain())
        return CommonApiResponse.success()
    }

    @PostMapping("/unfollow")
    fun unfollow(
        @RequestBody body: FollowShipRequest
    ): CommonApiResponse<Nothing> {
        followService.unfollow(body.toDomain())
        return CommonApiResponse.success()
    }

    @PostMapping("/songs")
    fun enrollSongs(
        @RequestBody body: EnrollSongsRequest
    ): CommonApiResponse<Nothing> {
        // TODO userId resolve
        userSongCreateService.create(body.toUserSongCreation(0L))
        return CommonApiResponse.success()
    }
}
