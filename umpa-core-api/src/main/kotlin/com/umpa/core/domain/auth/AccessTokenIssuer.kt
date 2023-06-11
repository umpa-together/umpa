package com.umpa.core.domain.auth

import com.umpa.storage.db.core.token.AccessTokenRepository
import org.springframework.stereotype.Component

@Component
class AccessTokenIssuer(
    private val tokenHandler: JwtTokenHandler,
    private val accessTokenRepository: AccessTokenRepository
) {
    fun issue(userId: Long): TokenBucket {
        val token = tokenHandler.issue(userId)
        accessTokenRepository.save(token.toEntity(userId))
        return token
    }
}
