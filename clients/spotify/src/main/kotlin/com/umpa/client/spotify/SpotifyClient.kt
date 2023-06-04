package com.umpa.client.spotify

import com.umpa.client.spotify.auth.basicAuth
import com.umpa.client.spotify.auth.bearerAuth
import com.umpa.client.spotify.response.TrackResponse
import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Component
import java.net.URI

@Component
class SpotifyClient(
    private val spotifyApi: SpotifyApi,
    @Value("\${spotify.api.authorization.url}")
    private val authorizationBaseUrl: String,
    @Value("\${spotify.api.client.key}")
    private val clientKey: String,
    @Value("\${spotify.api.secret.key}")
    private val secretKey: String
) {
    fun getAccessToken(): String {
        val token = spotifyApi.getAccessToken(
            uri = URI(authorizationBaseUrl),
            auth = basicAuth(clientKey, secretKey)
        ).token
        // TODO token caching
        return token
    }

    fun search(keyword: String, limit: Int?, offset: Int?): TrackResponse {
        val token = getAccessToken()
        return spotifyApi.search(
            auth = bearerAuth(token),
            keyword = keyword,
            limit = limit,
            offset = offset
        ).tracks
    }
}
