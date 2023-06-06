package com.umpa.core.domain.content.playlist

import com.umpa.commons.enums.ContentType
import com.umpa.core.domain.feed.FeedCreator
import com.umpa.core.domain.hashtag.HashtagCreator
import com.umpa.core.domain.song.SongCreator
import jakarta.transaction.Transactional
import org.springframework.stereotype.Component

@Component
class PlaylistCreatorWrapper(
    private val playlistCreator: PlaylistCreator,
    private val songCreator: SongCreator,
    private val feedCreator: FeedCreator,
    private val hashtagCreator: HashtagCreator
) {
    @Transactional
    fun create(creation: PlaylistCreation): Playlist {
        val playlist = playlistCreator.create(creation)
        songCreator.create(
            creation.toSongCreations(contentId = playlist.id, contentType = ContentType.PLAYLIST)
        )
        feedCreator.create(
            creation.toFeedCreation(contentId = playlist.id, contentType = ContentType.PLAYLIST)
        )
        hashtagCreator.create(
            creation.toHashtagCreations(contentId = playlist.id)
        )
        return Playlist.fromEntity(playlist)
    }
}
