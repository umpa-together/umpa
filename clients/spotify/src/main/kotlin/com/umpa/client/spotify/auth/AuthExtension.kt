package com.umpa.client.spotify.auth

import java.util.Base64

typealias BasicAuth = String

fun basicAuth(client: String, secret: String): String = "Basic ${Base64.getEncoder().encodeToString(
    "$client:$secret".toByteArray()
)}"
