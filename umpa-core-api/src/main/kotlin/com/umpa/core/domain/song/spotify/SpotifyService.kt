package com.umpa.core.domain.song.spotify

import com.umpa.client.spotify.SpotifyClient
import com.umpa.core.domain.cursor.CursorKey
import org.springframework.stereotype.Service

@Service
class SpotifyService(
    private val spotifyClient: SpotifyClient
) {
    fun search(keyword: String, cursor: String?): SearchResult {
        val cursorKey = cursor?.let {
            CursorKey.fromBase64(it)
        }
        val searchResults = spotifyClient.search(
            keyword = keyword,
            limit = cursorKey?.limit,
            offset = cursorKey?.offset
        )
        return SearchResult.fromTrackResponse(searchResults)
    }
}
