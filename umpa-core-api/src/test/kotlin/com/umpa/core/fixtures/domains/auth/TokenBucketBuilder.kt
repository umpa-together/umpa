package com.umpa.core.fixtures.domains.auth

import com.umpa.core.domain.auth.Token
import com.umpa.core.domain.auth.TokenBucket
import java.time.LocalDateTime

class TokenBucketBuilder(
    val accessToken: Token = "access-token",
    val refreshToken: Token = "refresh-token",
    val expiredAt: LocalDateTime = LocalDateTime.now().plusDays(1)
) {
    fun build(): TokenBucket {
        return TokenBucket(
            accessToken = accessToken,
            refreshToken = refreshToken,
            expiredAt = expiredAt
        )
    }
}
