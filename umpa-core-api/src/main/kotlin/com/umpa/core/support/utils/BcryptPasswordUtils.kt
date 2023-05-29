package com.umpa.core.support.utils

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder

object BcryptPasswordUtils {
    private val bCryptPasswordEncoder = BCryptPasswordEncoder(BCryptPasswordEncoder.BCryptVersion.`$2B`, 10)

    fun encode(plainText: String): String {
        return bCryptPasswordEncoder.encode(plainText)
    }

    fun match(plainText: String, hashValue: String): Boolean {
        return bCryptPasswordEncoder.matches(plainText, hashValue)
    }
}
