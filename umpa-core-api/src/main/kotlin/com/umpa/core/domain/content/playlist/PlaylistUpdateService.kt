package com.umpa.core.domain.content.playlist

import org.springframework.stereotype.Service

@Service
class PlaylistUpdateService(
    private val playlistUpdater: PlaylistUpdaterWrapper,
    private val playlistDetailFiller: PlaylistDetailFiller
) {
    fun edit(revision: PlaylistRevision): PlaylistDetail {
        val playlist = playlistUpdater.edit(revision)
        return playlistDetailFiller.fill(playlist)
    }
}
