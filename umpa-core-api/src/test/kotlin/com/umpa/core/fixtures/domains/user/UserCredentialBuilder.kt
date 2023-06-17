package com.umpa.core.fixtures.domains.user

import com.umpa.core.domain.user.UserCredential

class UserCredentialBuilder(
    val email: String = "test@gmail.com",
    val password: String = "Azzz1234!aaa"
) {
    fun build(): UserCredential {
        return UserCredential(
            email = email,
            password = password
        )
    }
}
