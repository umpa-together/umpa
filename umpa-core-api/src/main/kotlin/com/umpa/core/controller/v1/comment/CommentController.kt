package com.umpa.core.controller.v1.comment

import com.umpa.commons.api.response.CommonApiResponse
import com.umpa.core.controller.v1.comment.request.CreateCommentRequest
import com.umpa.core.domain.comment.CommentRemoval
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

    @DeleteMapping("/{id}/comments/{commentId}")
    fun removeComment(
        @PathVariable id: Long,
        @PathVariable commentId: Long
    ): CommonApiResponse<Nothing> {
        // TODO 헤더로 넘어온 access-token에서 userId resolve해서 넘겨주어야 함
        commentService.remove(CommentRemoval(contentId = id, commentId = commentId, userId = 0L))
        return CommonApiResponse.success()
    }

    @PostMapping("/{id}/comments/{commentId}/re-comments")
    fun createReComment(
        @PathVariable id: Long,
        @PathVariable commentId: Long,
        @RequestBody body: CreateCommentRequest
    ): CommonApiResponse<Nothing> {
        // TODO 헤더로 넘어온 access-token에서 userId resolve해서 넘겨주어야 함
        commentService.create(body.toDomain(userId = 0L, contentId = id, parentCommentId = commentId))
        return CommonApiResponse.success()
    }

    @DeleteMapping("/{id}/comments/{commentId}/re-comments/{reCommentId}")
    fun removeReComment(
        @PathVariable id: Long,
        @PathVariable commentId: Long,
        @PathVariable reCommentId: Long
    ): CommonApiResponse<Nothing> {
        // TODO 헤더로 넘어온 access-token에서 userId resolve해서 넘겨주어야 함
        commentService.remove(
            CommentRemoval(contentId = id, commentId = reCommentId, parentCommentId = commentId, userId = 0L)
        )
        return CommonApiResponse.success()
    }
}
