package com.umpa.core.domain.content.daily

import com.umpa.core.support.exceptions.CoreApiException
import com.umpa.core.support.exceptions.ErrorType
import org.springframework.stereotype.Component

@Component
class DailyDeleteService(
    private val dailyReader: DailyReader,
    private val dailyDeleter: DailyDeleterWrapper
) {
    fun delete(dailyId: Long, userId: Long) {
        val daily = dailyReader.readById(dailyId)
        if (canDelete(daily, userId)) {
            dailyDeleter.delete(dailyId)
        } else {
            throw CoreApiException(ErrorType.FORBIDDEN_DELETE_DAILY)
        }
    }

    private fun canDelete(daily: Daily, userId: Long): Boolean {
        return !daily.isNotMyDaily(userId)
    }
}
