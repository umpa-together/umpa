package com.umpa.core.fixtures.domains.content.daily

import com.umpa.core.domain.comment.CommentDetail
import com.umpa.core.domain.content.daily.Daily
import com.umpa.core.domain.content.daily.DailyDetail
import com.umpa.core.domain.song.spotify.Track
import com.umpa.core.domain.user.User
import com.umpa.core.fixtures.domains.user.UserBuilder

class DailyDetailBuilder(
    val daily: Daily = DailyBuilder().build(),
    val postUser: User = UserBuilder().build(),
    val songs: List<Track> = emptyList(),
    val hashtags: List<String> = emptyList(),
    val comments: List<CommentDetail> = emptyList()
) {
    fun build(): DailyDetail {
        return DailyDetail(
            daily = daily,
            postUser = postUser,
            songs = songs,
            hashtags = hashtags,
            comments = comments
        )
    }
}
