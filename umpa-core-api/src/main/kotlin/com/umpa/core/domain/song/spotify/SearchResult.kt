package com.umpa.core.domain.song.spotify

import com.umpa.client.spotify.response.TrackResponse

data class SearchResult(
    val next: String?,
    val songs: List<Track>
) {
    companion object {
        fun fromTrackResponse(response: TrackResponse): SearchResult {
            return SearchResult(
                next = response.next,
                songs = response.items.map { Track.fromTrackDetailResponse(it) }
            )
        }
    }
}
