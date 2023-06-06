package com.umpa.core.controller.v1.spotiffy

import com.umpa.core.controller.v1.spotiffy.response.SearchResponse
import com.umpa.core.domain.song.spotify.SpotifyService
import com.umpa.commons.api.response.CommonApiResponse
import org.springframework.http.MediaType
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/v1/spotify/songs")
class SpotifyController(
    private val spotifyService: SpotifyService
) {
    @GetMapping(
        value = ["/search"],
        consumes = [MediaType.APPLICATION_JSON_VALUE],
        produces = [MediaType.APPLICATION_JSON_VALUE]
    )
    fun search(
        @RequestParam keyword: String,
        @RequestParam cursor: String?
    ): CommonApiResponse<SearchResponse> {
        val result = spotifyService.search(keyword, cursor)
        return CommonApiResponse.success(SearchResponse.fromSearchResult(result))
    }
}
