package com.umpa.core.domain.content.daily

import com.umpa.storage.db.core.daily.DailyEntity
import com.umpa.storage.db.core.daily.DailyRepository
import org.springframework.stereotype.Component

@Component
class DailyCreator(
    private val dailyRepository: DailyRepository
) {
    fun create(creation: DailyCreation): DailyEntity {
        return dailyRepository.save(creation.toEntity())
    }
}
