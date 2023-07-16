package com.umpa.core.domain.content.daily

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
}
