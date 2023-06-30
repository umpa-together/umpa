package com.umpa.core.domain.comment

import com.umpa.core.domain.user.UserProfile
import java.time.LocalDateTime

interface EachComment {
    val id: Long
    val createdAt: LocalDateTime
    val comment: String
    val userProfile: UserProfile
}
