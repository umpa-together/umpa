package com.umpa.core.controller.v1.content.playlist

import com.umpa.core.controller.v1.content.playlist.request.PlaylistCreateRequest
import com.umpa.core.controller.v1.content.playlist.response.PlaylistDetailResponse
import com.umpa.core.domain.content.playlist.PlaylistCreateService
import com.umpa.response.CommonApiResponse
import jakarta.validation.Valid
import org.springframework.http.MediaType
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/v1/playlists")
class PlaylistController(
    private val playlistCreateService: PlaylistCreateService
) {
    @PostMapping(
//        consumes = [MediaType.MULTIPART_FORM_DATA_VALUE],
        consumes = [MediaType.APPLICATION_JSON_VALUE],
        produces = [MediaType.APPLICATION_JSON_VALUE]
    )
    fun create(
        @Valid @RequestBody
        body: PlaylistCreateRequest
    ): CommonApiResponse<PlaylistDetailResponse> {
        // TODO 헤더로 넘어온 access-token에서 userId resolve해서 넘겨주어야 함
        val result = playlistCreateService.create(body.toDomain(0L))
        return CommonApiResponse.success(PlaylistDetailResponse.fromPlaylistDetail(result))
    }
}
