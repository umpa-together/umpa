package com.umpa.client.spotify

import com.umpa.client.spotify.auth.basicAuth
import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Component

@Component
class SpotifyClient(
    private val spotifyApi: SpotifyApi,
    @Value("\${spotify.api.client.key}")
    private val clientKey: String,
    @Value("\${spotify.api.secret.key}")
    private val secretKey: String
) {
    fun getAccessToken(): String {
        val token = spotifyApi.getAccessToken(
            auth = basicAuth(clientKey, secretKey)
        ).token
        // TODO token caching
        return token
    }
}
