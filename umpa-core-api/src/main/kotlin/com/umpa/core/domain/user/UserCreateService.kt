package com.umpa.core.domain.user

import org.springframework.stereotype.Service

@Service
class UserCreateService(
    private val userValidator: UserValidator,
    private val userCreator: UserCreator
) {
    fun create(credential: UserCredential): String {
        userValidator.validateDuplicateByEmail(credential.email)
        val user = userCreator.create(credential)
        // FIXME return accessToken
        return "accessToken"
    }
}
