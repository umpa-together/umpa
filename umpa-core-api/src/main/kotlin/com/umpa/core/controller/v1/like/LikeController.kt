package com.umpa.core.controller.v1.like

import com.umpa.commons.api.response.CommonApiResponse
import com.umpa.core.controller.v1.like.request.LikeRequest
import com.umpa.core.domain.like.LikeService
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping(
    "/v1/likes"
)
class LikeController(
    private val likeService: LikeService
) {
    @PostMapping
    fun like(
        @RequestBody body: LikeRequest
    ): CommonApiResponse<Nothing> {
        // TODO 헤더로 넘어온 access-token에서 userId resolve해서 넘겨주어야 함
        likeService.like(body.toDomain(userId = 0L))
        return CommonApiResponse.success()
    }
}
