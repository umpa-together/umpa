package com.umpa.core.domain.user

import com.umpa.core.support.constants.ImageConstants
import com.umpa.storage.db.core.user.UserEntity

data class UserProfile(
    val id: Long,
    val nickName: String,
    val profileImage: String
) {
    companion object {
        fun fromEntity(entity: UserEntity): UserProfile {
            return UserProfile(
                id = entity.id,
                nickName = entity.nickName!!,
                profileImage = entity.profileImage ?: ImageConstants.DEFAULT_PROFILE_IMAGE
            )
        }

        fun fromUser(user: User): UserProfile {
            return UserProfile(
                id = user.id,
                nickName = user.nickName!!,
                profileImage = user.profileImage
            )
        }
    }
}
