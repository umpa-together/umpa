package com.umpa.core.domain.content.daily

import com.umpa.core.domain.hashtag.HashtagUpdater
import com.umpa.core.domain.song.SongUpdater
import jakarta.transaction.Transactional
import org.springframework.stereotype.Component

@Component
class DailyDeleterWrapper(
    private val dailyUpdater: DailyUpdater,
    private val songUpdater: SongUpdater,
    private val hashtagUpdater: HashtagUpdater
) {
    @Transactional
    fun delete(dailyId: Long) {
        dailyUpdater.delete(dailyId)
        songUpdater.delete(dailyId)
        hashtagUpdater.delete(dailyId)
    }
}
