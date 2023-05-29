package com.umpa.core.domain.user

import org.springframework.stereotype.Service

@Service
class UserCreateService(
    private val userValidator: UserValidator,
    private val userCreator: UserCreator
) {
    fun create(creation: UserCreation): String {
        userValidator.validateDuplicateByEmail(creation.email)
        val user = userCreator.create(creation)
        // FIXME return accessToken
        return "accessToken"
    }
}
