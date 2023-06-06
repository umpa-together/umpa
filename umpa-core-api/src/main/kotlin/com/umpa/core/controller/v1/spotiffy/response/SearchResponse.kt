package com.umpa.core.controller.v1.spotiffy.response

import com.umpa.core.domain.cursor.CursorKey
import com.umpa.core.domain.song.spotify.SearchResult
import com.umpa.core.domain.song.spotify.Track

data class SearchResponse(
    val cursor: String?,
    val songs: List<Track>
) {
    companion object {
        fun fromSearchResult(result: SearchResult): SearchResponse {
            return SearchResponse(
                cursor = result.next?.let { CursorKey.extractFromUrl(it) }?.encode(),
                songs = result.songs
            )
        }
    }
}
