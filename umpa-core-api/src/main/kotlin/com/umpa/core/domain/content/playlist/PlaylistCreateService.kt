package com.umpa.core.domain.content.playlist

import org.springframework.stereotype.Service

@Service
class PlaylistCreateService(
    private val playlistCreator: PlaylistCreator
) {
    fun create(creation: PlaylistCreation) {
        val playlist = Playlist.fromEntity(playlistCreator.create(creation))
        // TODO 피드, 해시태그, 담은 곡 생성
        // feedCreator.create()
        // hashtagCreator.create(creation.hashtags)
    }
}
