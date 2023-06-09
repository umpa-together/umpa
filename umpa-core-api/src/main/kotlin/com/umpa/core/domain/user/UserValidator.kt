package com.umpa.core.domain.user

import com.umpa.core.support.exceptions.CoreApiException
import com.umpa.core.support.exceptions.ErrorType
import com.umpa.core.support.utils.BcryptPasswordUtils
import com.umpa.storage.db.core.user.UserRepository
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

    fun validatePassword(raw: String, encrypted: String) {
        val isMatchedPassword = BcryptPasswordUtils.match(raw, encrypted)
        if (!isMatchedPassword) {
            throw CoreApiException(ErrorType.BAD_CREDENTIALS)
        }
    }
}
