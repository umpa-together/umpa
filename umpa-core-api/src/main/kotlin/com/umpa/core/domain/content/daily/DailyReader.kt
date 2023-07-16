package com.umpa.core.domain.content.daily

import com.umpa.core.support.exceptions.CoreApiException
import com.umpa.core.support.exceptions.ErrorType
import com.umpa.storage.db.core.daily.DailyRepository
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Component

@Component
class DailyReader(
    private val dailyRepository: DailyRepository
) {
    fun readById(id: Long): Daily {
        return dailyRepository.findByIdOrNull(id)?.let {
            if (it.isDeleted) {
                throw CoreApiException(ErrorType.FORBIDDEN_DELETED_DAILY)
            }
            Daily.fromEntity(it)
        } ?: throw CoreApiException(ErrorType.NOT_FOUND_DAILY)
    }
}
