package com.umpa.core.domain.content.daily

import com.umpa.commons.enums.ContentType
import com.umpa.core.domain.feed.FeedCreator
import com.umpa.core.domain.hashtag.HashtagCreator
import com.umpa.core.domain.song.SongCreator
import jakarta.transaction.Transactional
import org.springframework.stereotype.Component

@Component
class DailyCreatorWrapper(
    private val dailyCreator: DailyCreator,
    private val songCreator: SongCreator,
    private val feedCreator: FeedCreator,
    private val hashtagCreator: HashtagCreator
) {
    @Transactional
    fun create(creation: DailyCreation): Daily {
        val daily = dailyCreator.create(creation)
        songCreator.create(
            creation.toSongCreations(contentId = daily.id, contentType = ContentType.DAILY)
        )
        feedCreator.create(
            creation.toFeedCreation(contentId = daily.id, contentType = ContentType.DAILY)
        )
        hashtagCreator.create(
            creation.toHashtagCreations(contentId = daily.id)
        )
        return Daily.fromEntity(daily)
    }
}
