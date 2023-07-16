package com.umpa.core.domain.content.daily

import com.umpa.core.support.exceptions.CoreApiException
import com.umpa.core.support.exceptions.ErrorType
import org.springframework.stereotype.Service

@Service
class DailyUpdateService(
    private val dailyReader: DailyReader,
    private val dailyUpdater: DailyUpdaterWrapper,
    private val dailyDetailFiller: DailyDetailFiller
) {
    fun edit(revision: DailyRevision): DailyDetail {
        validateEdition(revision.id, revision.userId)
        val daily = dailyUpdater.edit(revision)
        return dailyDetailFiller.fill(daily)
    }

    private fun validateEdition(dailyId: Long, userId: Long) {
        val daily = dailyReader.readById(dailyId)
        if (daily.isNotMyDaily(userId)) {
            throw CoreApiException(ErrorType.FORBIDDEN_EDIT_DAILY)
        }
    }
}
