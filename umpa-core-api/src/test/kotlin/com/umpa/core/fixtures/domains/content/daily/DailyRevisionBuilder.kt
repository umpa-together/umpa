package com.umpa.core.fixtures.domains.content.daily

import com.umpa.core.domain.content.daily.DailyRevision
import com.umpa.core.domain.song.spotify.Track

class DailyRevisionBuilder(
    val id: Long = 0L,
    val userId: Long = 0L,
    val content: String = "",
    val songs: List<Track> = emptyList(),
    val hashtags: List<String> = emptyList()
) {
    fun build(): DailyRevision {
        return DailyRevision(
            id = id,
            userId = userId,
            content = content,
            songs = songs,
            hashtags = hashtags
        )
    }
}
