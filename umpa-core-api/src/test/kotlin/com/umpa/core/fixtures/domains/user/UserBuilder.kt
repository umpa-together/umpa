package com.umpa.core.fixtures.domains.user

import com.umpa.core.domain.user.User
import com.umpa.core.support.constants.ImageConstants
import java.time.LocalDateTime

class UserBuilder(
    val id: Long = 0L,
    val createdAt: LocalDateTime? = LocalDateTime.now(),
    val updatedAt: LocalDateTime? = LocalDateTime.now(),
    val email: String = "",
    val password: String = "",
    val active: Boolean = true,
    val nickName: String? = "",
    val realName: String? = null,
    val introduction: String? = null,
    val profileImage: String = ImageConstants.DEFAULT_PROFILE_IMAGE,
    val backgroundImage: String = ImageConstants.DEFAULT_PROFILE_BACKGROUND_IMAGE,
    val accessedAt: LocalDateTime? = LocalDateTime.now()
) {
    fun build(): User {
        return User(
            id = id,
            createdAt = createdAt,
            updatedAt = updatedAt,
            email = email,
            password = password,
            active = active,
            nickName = nickName,
            realName = realName,
            introduction = introduction,
            profileImage = profileImage,
            backgroundImage = backgroundImage,
            accessedAt = accessedAt
        )
    }
}
