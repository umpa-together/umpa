package com.umpa.client.spotify.response

import com.fasterxml.jackson.annotation.JsonProperty

data class AccessTokenResponse(
    @field:JsonProperty("access_token")
    val token: String,
    @field:JsonProperty("token_type")
    val type: String,
    @field:JsonProperty("expires_in")
    val expires: Int
)
