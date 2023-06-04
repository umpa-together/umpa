package com.umpa.client.spotify.response

import com.fasterxml.jackson.annotation.JsonProperty

data class ArtistResponse(
    @field:JsonProperty("external_urls")
    val externalUrls: ExternalUrlResponse?,
    val followers: FollowersResponse?,
    val genres: List<String>?,
    val href: String?,
    val id: String?,
    val images: List<ImageResponse>?,
    val name: String?,
    val popularity: Int?,
    val type: String?,
    val uri: String?
) {
    data class FollowersResponse(
        val href: String?,
        val total: Int?
    )
}
