package com.umpa.core.domain.content.daily

import com.umpa.commons.enums.ContentType
import com.umpa.core.domain.hashtag.HashtagUpdater
import com.umpa.core.domain.song.SongUpdater
import jakarta.transaction.Transactional
import org.springframework.stereotype.Component

@Component
class DailyUpdaterWrapper(
    private val dailyUpdater: DailyUpdater,
    private val songUpdater: SongUpdater,
    private val hashtagUpdater: HashtagUpdater
) {
    @Transactional
    fun edit(revision: DailyRevision): Daily {
        val daily = dailyUpdater.edit(revision)
        songUpdater.edit(revision.id, revision.toSongCreations(ContentType.DAILY))
        hashtagUpdater.edit(revision.id, revision.toHashtagCreations())
        return daily
    }
}
