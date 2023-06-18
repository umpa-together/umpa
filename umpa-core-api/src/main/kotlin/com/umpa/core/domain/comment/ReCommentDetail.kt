package com.umpa.core.domain.comment

import com.umpa.core.domain.user.UserProfile
import java.time.LocalDateTime

data class ReCommentDetail(
    val id: Long,
    val createdAt: LocalDateTime,
    val comment: String,
    val reComments: List<ReCommentDetail>,
    val userProfile: UserProfile,
)
