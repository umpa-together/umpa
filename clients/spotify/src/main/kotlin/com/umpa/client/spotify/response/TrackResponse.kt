package com.umpa.client.spotify.response

data class TrackResponse(
    val href: String,
    val limit: Int,
    val next: String?,
    val offset: Int,
    val previous: String?,
    val total: Int,
    val items: List<TrackDetailResponse>
)
