package com.umpa.core.controller.v1.content.daily.request

import com.umpa.core.controller.v1.spotiffy.request.TrackRequest
import com.umpa.core.domain.content.daily.DailyRevision
import com.umpa.core.support.exceptions.CoreApiException
import com.umpa.core.support.exceptions.ErrorType
import com.umpa.core.support.utils.PatternUtils
import jakarta.validation.constraints.Size

data class DailyEditRequest(
    @field:Size(max = 150, message = "내용은 최대 150글자 입니다.")
    val content: String,
    val songs: List<TrackRequest>,
    val hashtags: List<String>
) {
    init {
        validate()
    }

    private fun validate() {
        // TODO song 갯수 확인
        if (songs.size < 3 || songs.size > 8) {
            throw CoreApiException(ErrorType.NOT_SUPPORTED_SONGS_COUNT)
        }
        if (hashtags.any { !PatternUtils.isKorAndEngAndNumAndNotSpc(it) }) {
            throw CoreApiException(ErrorType.NOT_SUPPORTED_SPC_PATTERN)
        }
    }

    fun toDomain(dailyId: Long, userId: Long): DailyRevision {
        return DailyRevision(
            id = dailyId,
            userId = userId,
            content = content,
            songs = songs.map { it.toDomain() },
            hashtags = hashtags
        )
    }
}
