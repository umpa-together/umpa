package com.umpa.core.domain.user

import com.umpa.user.UserEntity
import com.umpa.user.UserRepository
import org.springframework.stereotype.Component
import java.time.LocalDateTime

@Component
class UserCreator(
    private val repository: UserRepository
) {
    fun create(credential: UserCredential): UserEntity {
        return repository.save(
            UserEntity(
                email = credential.email,
                password = credential.getEncryptedPassword(),
                accessedAt = LocalDateTime.now()
            )
        )
    }
}
