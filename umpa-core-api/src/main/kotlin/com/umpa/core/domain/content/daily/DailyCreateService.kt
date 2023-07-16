package com.umpa.core.domain.content.daily

import com.umpa.core.domain.user.UserReader
import org.springframework.stereotype.Service

@Service
class DailyCreateService(
    private val dailyCreator: DailyCreatorWrapper,
    private val userReader: UserReader
) {
    fun create(creation: DailyCreation): DailyDetail {
        val daily = dailyCreator.create(creation)
        val user = userReader.readById(daily.userId)
        // TODO 이미지 업로드
        return DailyDetail(
            daily = daily,
            postUser = user,
            songs = creation.songs,
            hashtags = creation.hashtags,
            comments = emptyList()
        )
    }
}
