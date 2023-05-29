package com.umpa.core.domain.user

import com.umpa.user.UserEntity
import com.umpa.user.UserRepository
import org.springframework.stereotype.Component
import java.time.LocalDateTime

@Component
class UserCreator(
    private val repository: UserRepository
) {
    fun create(creation: UserCreation): UserEntity {
        return repository.save(
            UserEntity(
                email = creation.email,
                password = creation.getEncryptedPassword(),
                accessedAt = LocalDateTime.now()
            )
        )
    }
}
