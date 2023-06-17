package com.umpa.core.domain.auth

import com.umpa.storage.db.core.token.AccessTokenEntity
import java.time.LocalDateTime

data class TokenBucket(
    val accessToken: Token,
    val refreshToken: Token,
    val expiredAt: LocalDateTime
) {
    fun toEntity(userId: Long): AccessTokenEntity {
        return AccessTokenEntity(
            userId = userId,
            accessToken = accessToken,
            refreshToken = refreshToken,
            expiredAt = expiredAt
        )
    }
}
