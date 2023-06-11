package com.umpa.core.domain.auth

import java.time.LocalDateTime

data class TokenBucket(
    val accessToken: Token,
    val refreshToken: Token,
    val expiredAt: LocalDateTime
)
