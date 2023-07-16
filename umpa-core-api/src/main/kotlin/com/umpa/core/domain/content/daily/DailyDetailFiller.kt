package com.umpa.core.domain.content.daily

import com.umpa.core.domain.comment.CommentDetailGetter
import com.umpa.core.domain.hashtag.HashtagReader
import com.umpa.core.domain.song.SongReader
import com.umpa.core.domain.user.UserReader
import org.springframework.stereotype.Component

@Component
class DailyDetailFiller(
    private val userReader: UserReader,
    private val songReader: SongReader,
    private val hashtagReader: HashtagReader,
    private val commentDetailGetter: CommentDetailGetter
) {
    fun fill(daily: Daily): DailyDetail {
        val contentId = daily.id
        val user = userReader.readById(daily.userId)
        val songs = songReader.readByContentId(contentId)
        val hashtags = hashtagReader.readByContentId(contentId)
        val commentDetails = commentDetailGetter.get(contentId)
        return DailyDetail(
            daily = daily,
            postUser = user,
            songs = songs,
            hashtags = hashtags,
            comments = commentDetails
        )
    }
}
