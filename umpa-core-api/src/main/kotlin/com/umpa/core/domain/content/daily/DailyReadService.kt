package com.umpa.core.domain.content.daily

import org.springframework.stereotype.Service

@Service
class DailyReadService(
    private val dailyReader: DailyReader,
    private val dailyUpdater: DailyUpdater,
    private val dailyDetailFiller: DailyDetailFiller
) {
    fun readById(id: Long, userId: Long): DailyDetail {
        val daily = dailyReader.readById(id)
        increaseViewCountIfPostUserIsOther(daily, userId)
        return dailyDetailFiller.fill(daily)
    }

    private fun increaseViewCountIfPostUserIsOther(daily: Daily, userId: Long) {
        if (daily.isNotMyDaily(userId)) {
            dailyUpdater.increaseViewCount(daily.id)
        }
    }
}
