package com.umpa.core.domain.user

import com.umpa.core.support.exceptions.CoreApiException
import com.umpa.core.support.exceptions.ErrorType
import com.umpa.user.UserRepository
import org.springframework.stereotype.Component

@Component
class UserValidator(
    private val repository: UserRepository
) {
    fun validateDuplicateByEmail(email: String) {
        if (repository.existsByEmail(email)) {
            throw CoreApiException(ErrorType.ALREADY_EXISTS_EMAIL)
        }
    }
}
