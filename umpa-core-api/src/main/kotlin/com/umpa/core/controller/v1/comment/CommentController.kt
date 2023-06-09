package com.umpa.core.controller.v1.comment

import com.umpa.commons.api.response.CommonApiResponse
import com.umpa.core.controller.v1.comment.request.CreateCommentRequest
import com.umpa.core.domain.comment.CommentService
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping(
    "/v1/playlists"
)
class CommentController(
    private val commentService: CommentService
) {
    @PostMapping("/{id}/comments")
    fun createComment(
        @PathVariable id: Long,
        @RequestBody body: CreateCommentRequest
    ): CommonApiResponse<Nothing> {
        // TODO 헤더로 넘어온 access-token에서 userId resolve해서 넘겨주어야 함
        commentService.create(body.toDomain(userId = 0L, contentId = id))
        return CommonApiResponse.success()
    }
}
