package com.umpa.core.domain.user

import com.umpa.core.support.constants.ImageConstants
import com.umpa.storage.db.core.user.UserEntity
import java.time.LocalDateTime

data class User(
    val id: Long,
    val createdAt: LocalDateTime?,
    val updatedAt: LocalDateTime?,
    val email: String,
    val password: String,
    val active: Boolean,
    val nickName: String?,
    val realName: String?,
    val introduction: String?,
    val profileImage: String,
    val backgroundImage: String?,
    val accessedAt: LocalDateTime?
) {
    companion object {
        fun fromEntity(entity: UserEntity): User {
            return User(
                id = entity.id,
                createdAt = entity.createdAt,
                updatedAt = entity.updatedAt,
                email = entity.email,
                password = entity.password,
                active = entity.active,
                nickName = entity.nickName,
                realName = entity.realName,
                introduction = entity.introduction,
                profileImage = entity.profileImage ?: ImageConstants.DEFAULT_PROFILE_IMAGE,
                backgroundImage = entity.backgroundImage,
                accessedAt = entity.accessedAt
            )
        }
    }

    fun userProfile(): UserProfile {
        return UserProfile.fromUser(this)
    }
}
