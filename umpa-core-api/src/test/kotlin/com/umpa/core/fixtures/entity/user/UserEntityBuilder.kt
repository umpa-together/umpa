package com.umpa.core.fixtures.entity.user

import com.umpa.storage.db.core.user.UserEntity
import java.time.LocalDateTime

class UserEntityBuilder(
    val id: Long = 0L,
    val createdAt: LocalDateTime? = null,
    val updatedAt: LocalDateTime? = null,
    val email: String = "",
    val password: String = "",
    val active: Boolean = true,
    val nickName: String? = null,
    val realName: String? = null,
    val introduction: String? = null,
    val profileImage: String? = null,
    val backgroundImage: String? = null,
    val accessedAt: LocalDateTime? = null
) {
    fun build(): UserEntity {
        return UserEntity(
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
