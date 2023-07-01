package com.umpa.core.controller.v1.content.playlist

import com.umpa.core.controller.v1.content.playlist.request.PlaylistCreateRequest
import com.umpa.core.controller.v1.content.playlist.response.PlaylistDetailResponse
import com.umpa.core.domain.content.playlist.PlaylistCreateService
import com.umpa.commons.api.response.CommonApiResponse
import com.umpa.core.controller.v1.content.playlist.request.PlaylistEditRequest
import com.umpa.core.domain.content.playlist.PlaylistDeleteService
import com.umpa.core.domain.content.playlist.PlaylistReadService
import com.umpa.core.domain.content.playlist.PlaylistUpdateService
import jakarta.validation.Valid
import org.springframework.http.MediaType
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/v1/playlists")
class PlaylistController(
    private val playlistCreateService: PlaylistCreateService,
    private val playlistReadService: PlaylistReadService,
    private val playlistUpdateService: PlaylistUpdateService,
    private val playlistDeleteService: PlaylistDeleteService
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

    @GetMapping("/{id}")
    fun getDetail(
        @PathVariable id: Long
    ): CommonApiResponse<PlaylistDetailResponse> {
        // TODO 헤더로 넘어온 access-token에서 userId resolve해서 넘겨주어야 함
        val result = playlistReadService.readById(id, 0L)
        return CommonApiResponse.success(PlaylistDetailResponse.fromPlaylistDetail(result))
    }

    @PutMapping("/{id}")
    fun edit(
        @PathVariable id: Long,
        @RequestBody body: PlaylistEditRequest
    ): CommonApiResponse<PlaylistDetailResponse> {
        // TODO 헤더로 넘어온 access-token에서 userId resolve해서 넘겨주어야 함
        val result = playlistUpdateService.edit(body.toDomain(playlistId = id, userId = 0L))
        return CommonApiResponse.success(PlaylistDetailResponse.fromPlaylistDetail(result))
    }

    @DeleteMapping("/{id}")
    fun delete(
        @PathVariable id: Long
    ): CommonApiResponse<Nothing> {
        // TODO 헤더로 넘어온 access-token에서 userId resolve해서 넘겨주어야 함
        playlistDeleteService.delete(playlistId = id, userId = 0L)
        return CommonApiResponse.success()
    }
}
