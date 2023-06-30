package com.umpa.core.domain.content.playlist

import com.umpa.core.domain.comment.CommentDetailGetter
import com.umpa.core.domain.hashtag.HashtagReader
import com.umpa.core.domain.song.SongReader
import org.springframework.stereotype.Component

@Component
class PlaylistDetailFiller(
    private val songReader: SongReader,
    private val hashtagReader: HashtagReader,
    private val commentDetailGetter: CommentDetailGetter
) {
    fun fill(playlist: Playlist): PlaylistDetail {
        val contentId = playlist.id
        val songs = songReader.readByContentId(contentId)
        val hashtags = hashtagReader.readByContentId(contentId)
        val commentDetails = commentDetailGetter.get(contentId)
        return PlaylistDetail(
            playlist = playlist,
            songs = songs,
            hashtags = hashtags,
            comments = commentDetails
        )
    }
}
