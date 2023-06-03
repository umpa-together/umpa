package com.umpa.core.domain.user

import com.umpa.core.support.utils.BcryptPasswordUtils

data class UserCredential(
    val email: String,
    val password: String
) {
    fun getEncryptedPassword(): String {
        return BcryptPasswordUtils.encode(password)
    }
}
