package com.umpa.core.domain.content.playlist

import com.umpa.core.domain.hashtag.HashtagUpdater
import com.umpa.core.domain.song.SongUpdater
import jakarta.transaction.Transactional
import org.springframework.stereotype.Component

@Component
class PlaylistDeleterWrapper(
    private val playlistUpdater: PlaylistUpdater,
    private val songUpdater: SongUpdater,
    private val hashtagUpdater: HashtagUpdater
) {
    @Transactional
    fun delete(playlistId: Long) {
        playlistUpdater.delete(playlistId)
        songUpdater.delete(playlistId)
        hashtagUpdater.delete(playlistId)
    }
}
