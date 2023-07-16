package com.umpa.core.domain.content.daily

import com.umpa.core.support.exceptions.CoreApiException
import com.umpa.core.support.exceptions.ErrorType
import com.umpa.storage.db.core.daily.DailyRepository
import jakarta.transaction.Transactional
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Component

@Component
class DailyUpdater(
    private val dailyRepository: DailyRepository
) {
    @Transactional
    fun increaseViewCount(id: Long) {
        dailyRepository.findByIdOrNull(id)?.apply { this.increaseViewCount() }
    }

    @Transactional
    fun edit(revision: DailyRevision): Daily {
        return dailyRepository.findByIdOrNull(revision.id)
            ?.apply { this.editDaily(revision.content) }
            ?.let { Daily.fromEntity(it) }
            ?: throw CoreApiException(ErrorType.NOT_FOUND_DAILY)
    }

    @Transactional
    fun delete(id: Long) {
        dailyRepository.findByIdOrNull(id)
            ?.apply { this.delete() }
            ?: throw CoreApiException(ErrorType.NOT_FOUND_DAILY)
    }
}
