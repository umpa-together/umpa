package com.umpa.core.domain.content.playlist

import com.umpa.commons.enums.ContentType
import com.umpa.core.domain.hashtag.HashtagUpdater
import com.umpa.core.domain.song.SongUpdater
import jakarta.transaction.Transactional
import org.springframework.stereotype.Component

@Component
class PlaylistUpdaterWrapper(
    private val playlistUpdater: PlaylistUpdater,
    private val songUpdater: SongUpdater,
    private val hashtagUpdater: HashtagUpdater
) {

    @Transactional
    fun edit(revision: PlaylistRevision): Playlist {
        val playlist = playlistUpdater.edit(revision)
        songUpdater.edit(revision.id, revision.toSongCreations(ContentType.PLAYLIST))
        hashtagUpdater.edit(revision.id, revision.toHashtagCreations())
        return playlist
    }
}
