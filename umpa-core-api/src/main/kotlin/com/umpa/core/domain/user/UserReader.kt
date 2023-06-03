package com.umpa.core.domain.user

import com.umpa.core.support.exceptions.CoreApiException
import com.umpa.core.support.exceptions.ErrorType
import com.umpa.user.UserEntity
import com.umpa.user.UserRepository
import org.springframework.stereotype.Component

@Component
class UserReader(
    private val repository: UserRepository
) {
    fun readByEmail(email: String): UserEntity {
        return repository.findOneByEmail(email)
            ?: throw CoreApiException(ErrorType.NOT_FOUND_USER_EMAIL)
    }
}
