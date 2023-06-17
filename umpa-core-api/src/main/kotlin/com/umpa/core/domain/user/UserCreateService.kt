package com.umpa.core.domain.user

import com.umpa.core.domain.auth.AccessTokenIssuer
import com.umpa.core.domain.auth.TokenBucket
import org.springframework.stereotype.Service

@Service
class UserCreateService(
    private val userValidator: UserValidator,
    private val userCreator: UserCreator,
    private val accessTokenIssuer: AccessTokenIssuer
) {
    fun create(credential: UserCredential): TokenBucket {
        userValidator.validateDuplicateByEmail(credential.email)
        val user = userCreator.create(credential)
        return accessTokenIssuer.issue(user.id)
    }
}
