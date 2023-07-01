package com.umpa.core.controller.v1.user.response

import com.umpa.core.domain.user.UserProfile

data class PostUserResponse(
    val id: Long,
    val nickName: String,
    val profileImage: String
) {
    companion object {
        fun fromUserProfile(profile: UserProfile): PostUserResponse {
            return PostUserResponse(
                id = profile.id,
                nickName = profile.nickName,
                profileImage = profile.profileImage
            )
        }
    }
}
