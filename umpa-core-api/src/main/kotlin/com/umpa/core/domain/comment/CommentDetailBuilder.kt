package com.umpa.core.domain.comment

import com.umpa.core.domain.user.User

object CommentDetailBuilder {
    fun build(allComments: List<Comment>, users: List<User>): List<CommentDetail> {
        val comments = getParentComments(allComments, users)
        val reComments = getReComments(allComments, users)
        return aggregateCommentAndReComment(comments, reComments)
    }

    private fun getParentComments(comments: List<Comment>, users: List<User>): List<CommentDetail> {
        return comments.filter { it.isParentComment() }
            .map { CommentDetail.fromComment(it, users) }
    }

    private fun getReComments(comments: List<Comment>, users: List<User>): List<ReCommentDetail> {
        return comments.filter { it.isReComment() }
            .map { ReCommentDetail.fromComment(it, users) }
    }

    private fun aggregateCommentAndReComment(comments: List<CommentDetail>, reComments: List<ReCommentDetail>): List<CommentDetail> {
        val reCommentsGroupByParentComment = reComments.groupBy { it.parentCommentId }
        comments.forEach {
            val target = reCommentsGroupByParentComment[it.id]
            if (target != null) {
                it.updateReComments(target)
            }
        }
        return comments
    }
}
