package com.umpa.client.spotify

import com.umpa.client.spotify.auth.BasicAuth
import com.umpa.client.spotify.response.AccessTokenResponse
import org.springframework.cloud.openfeign.FeignClient
import org.springframework.http.MediaType
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestHeader
import org.springframework.web.bind.annotation.RequestParam

@FeignClient(
    name = "spotify-api",
    url = "\${spotify.api.url}"
)
interface SpotifyApi {

    @PostMapping(
        value = ["/api/token"],
        consumes = [MediaType.APPLICATION_FORM_URLENCODED_VALUE],
        produces = [MediaType.APPLICATION_JSON_VALUE]
    )
    fun getAccessToken(
        @RequestHeader("Authorization") auth: BasicAuth,
        @RequestParam("grant_type") grantType: String = "client_credentials"
    ): AccessTokenResponse
}
