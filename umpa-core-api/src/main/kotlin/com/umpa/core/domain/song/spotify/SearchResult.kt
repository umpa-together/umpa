package com.umpa.core.domain.song.spotify

import com.umpa.client.spotify.response.TrackResponse

data class SearchResult(
    val next: String?,
    val tracks: List<Track>
) {
    companion object {
        fun fromTrackResponse(response: TrackResponse): SearchResult {
            return SearchResult(
                next = response.next,
                tracks = response.items.map { Track.fromTrackDetailResponse(it) }
            )
        }
    }
}
