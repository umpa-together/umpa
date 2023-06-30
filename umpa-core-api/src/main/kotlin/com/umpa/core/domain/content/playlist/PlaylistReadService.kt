package com.umpa.core.domain.content.playlist

import org.springframework.stereotype.Service

@Service
class PlaylistReadService(
    private val playlistReader: PlaylistReader,
    private val playlistDetailFiller: PlaylistDetailFiller
) {
    fun readById(id: Long): PlaylistDetail {
        val playlist = playlistReader.readById(id)
        // TODO 내가 만든 플리가 아니면 view + 1
        return playlistDetailFiller.fill(playlist)
    }
}
