package com.umpa.core.domain.content.playlist

import org.springframework.stereotype.Service

@Service
class PlaylistReadService(
    private val playlistReader: PlaylistReader,
    private val playlistDetailFiller: PlaylistDetailFiller,
    private val playlistUpdater: PlaylistUpdater
) {
    fun readById(id: Long, userId: Long): PlaylistDetail {
        val playlist = playlistReader.readById(id)
        increaseViewCountIfPostUserIsOther(playlist, userId)
        return playlistDetailFiller.fill(playlist)
    }

    private fun increaseViewCountIfPostUserIsOther(playlist: Playlist, userId: Long) {
        if (playlist.isNotMyPlaylist(userId)) {
            playlistUpdater.increaseViewCount(playlist.id)
        }
    }
}
