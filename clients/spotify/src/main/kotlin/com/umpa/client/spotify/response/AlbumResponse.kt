package com.umpa.client.spotify.response

import com.fasterxml.jackson.annotation.JsonProperty

data class AlbumResponse(
    @field:JsonProperty("album_type")
    val albumType: String,
    @field:JsonProperty("total_tracks")
    val totalTracks: Int,
    @field:JsonProperty("available_markets")
    val availableMarkets: List<String>,
    @field:JsonProperty("external_urls")
    val externalUrls: ExternalUrlResponse,
    val href: String,
    val id: String,
    val images: List<ImageResponse>,
    val name: String,
    @field:JsonProperty("release_date")
    val releaseDate: String,
    @field:JsonProperty("release_date_precision")
    val releaseDatePrecision: String,
    val restrictions: RestrictionResponse?,
    val type: String,
    val uri: String,
    val copyrights: List<CopyRightResponse>?,
    @field:JsonProperty("external_ids")
    val externalIds: List<ExternalIdResponse>?,
    val genres: List<String>?,
    val label: String?,
    val popularity: Int?,
    @field:JsonProperty("album_group")
    val albumGroup: String?,
    val artists: List<ArtistResponse>
) {
    data class CopyRightResponse(
        val text: String?,
        val type: String?
    )

    data class ArtistResponse(
        @field:JsonProperty("external_urls")
        val externalUrls: ExternalUrlResponse?,
        val href: String?,
        val id: String?,
        val name: String?,
        val type: String?,
        val uri: String?
    )
}
