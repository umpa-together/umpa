package com.umpa.client.spotify

import com.umpa.client.spotify.auth.BasicAuth
import com.umpa.client.spotify.auth.BearerAuth
import com.umpa.client.spotify.enums.FilterType
import com.umpa.client.spotify.response.AccessTokenResponse
import com.umpa.client.spotify.response.SearchResponse
import org.springframework.cloud.openfeign.FeignClient
import org.springframework.http.MediaType
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestHeader
import org.springframework.web.bind.annotation.RequestParam
import java.net.URI

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
        uri: URI,
        @RequestHeader("Authorization") auth: BasicAuth,
        @RequestParam("grant_type") grantType: String = "client_credentials"
    ): AccessTokenResponse

    @GetMapping(
        value = ["/v1/search"],
        consumes = [MediaType.APPLICATION_JSON_VALUE],
        produces = [MediaType.APPLICATION_JSON_VALUE]
    )
    fun search(
        @RequestHeader("Authorization") auth: BearerAuth,
        @RequestParam("q") keyword: String,
        @RequestParam type: String = FilterType.TRACK.name.lowercase(),
        @RequestParam limit: Int? = 20,
        @RequestParam offset: Int? = 0
    ): SearchResponse
}
