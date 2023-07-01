package com.umpa.core.domain.content.playlist

import com.umpa.core.domain.comment.CommentDetailGetter
import com.umpa.core.domain.hashtag.HashtagReader
import com.umpa.core.domain.song.SongReader
import com.umpa.core.domain.user.UserReader
import org.springframework.stereotype.Component

@Component
class PlaylistDetailFiller(
    private val userReader: UserReader,
    private val songReader: SongReader,
    private val hashtagReader: HashtagReader,
    private val commentDetailGetter: CommentDetailGetter
) {
    fun fill(playlist: Playlist): PlaylistDetail {
        val contentId = playlist.id
        val user = userReader.readById(playlist.userId)
        val songs = songReader.readByContentId(contentId)
        val hashtags = hashtagReader.readByContentId(contentId)
        val commentDetails = commentDetailGetter.get(contentId)
        return PlaylistDetail(
            playlist = playlist,
            postUser = user,
            songs = songs,
            hashtags = hashtags,
            comments = commentDetails
        )
    }
}
