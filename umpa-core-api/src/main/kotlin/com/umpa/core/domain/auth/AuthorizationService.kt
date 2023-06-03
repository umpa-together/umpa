package com.umpa.core.domain.auth

import com.umpa.core.domain.user.UserCredential
import com.umpa.core.domain.user.UserReader
import com.umpa.core.domain.user.UserValidator
import org.springframework.stereotype.Service

@Service
class AuthorizationService(
    private val userReader: UserReader,
    private val userValidator: UserValidator
) {
    fun login(credential: UserCredential): String {
        val user = userReader.readByEmail(credential.email)
        userValidator.validatePassword(credential.password, user.password)

        // TODO access-token 넘겨줘야 함.
        return "accessToken"
    }
}
