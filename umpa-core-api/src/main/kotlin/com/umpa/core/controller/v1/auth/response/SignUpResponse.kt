package com.umpa.core.controller.v1.auth.response

import com.umpa.core.domain.auth.Token
import com.umpa.core.domain.auth.TokenBucket

data class SignUpResponse(
    val accessToken: Token,
    val refreshToken: Token
) {
    constructor(bucket: TokenBucket) : this(
        accessToken = bucket.accessToken,
        refreshToken = bucket.refreshToken
    )
}
