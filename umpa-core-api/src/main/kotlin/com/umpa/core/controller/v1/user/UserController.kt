package com.umpa.core.controller.v1.user

import com.umpa.commons.api.response.CommonApiResponse
import com.umpa.core.controller.v1.user.request.EnrollSongsRequest
import com.umpa.core.controller.v1.user.request.FollowShipRequest
import com.umpa.core.controller.v1.user.response.OtherUserDetailResponse
import com.umpa.core.controller.v1.user.response.UserDetailResponse
import com.umpa.core.domain.follow.FollowService
import com.umpa.core.domain.user.UserDetailService
import com.umpa.core.domain.user.UserSongCreateService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/v1/users")
class UserController(
    private val userDetailService: UserDetailService,
    private val followService: FollowService,
    private val userSongCreateService: UserSongCreateService
) {
    @GetMapping("/me")
    fun getMyDetail(): CommonApiResponse<UserDetailResponse> {
        // TODO userId resolve
        val result = userDetailService.get(0L)
        return CommonApiResponse.success(UserDetailResponse(result))
    }

    @GetMapping("/{id}")
    fun getOtherDetail(
        @PathVariable id: Long
    ): CommonApiResponse<OtherUserDetailResponse> {
        val result = userDetailService.get(id)
        // TODO userId resolve
        return CommonApiResponse.success(OtherUserDetailResponse(result, 0L))
    }

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
