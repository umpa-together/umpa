package com.umpa.core.controller.v1.content.playlist.request

import com.umpa.core.controller.v1.spotiffy.request.TrackRequest
import com.umpa.core.domain.content.playlist.PlaylistCreation
import com.umpa.core.support.exceptions.CoreApiException
import com.umpa.core.support.exceptions.ErrorType
import com.umpa.core.support.utils.PatternUtils
import jakarta.validation.constraints.NotBlank
import jakarta.validation.constraints.Size
import org.springframework.web.multipart.MultipartFile

data class PlaylistCreateRequest(
    @field:NotBlank(message = "제목은 필수입니다.")
    @field:Size(max = 30, message = "제목은 최대 30글자 입니다.")
    val title: String,
    @field:Size(max = 150, message = "내용은 최대 150글자 입니다.")
    val content: String,
    val songs: List<TrackRequest>,
    val hashtags: List<String>,
    val image: MultipartFile?
) {
    init {
        validate()
    }

    private fun validate() {
        if (songs.size < 3 || songs.size > 8) {
            throw CoreApiException(ErrorType.NOT_SUPPORTED_SONGS_COUNT)
        }
        if (hashtags.any { !PatternUtils.isKorAndEngAndNumAndNotSpc(it) }) {
            throw CoreApiException(ErrorType.NOT_SUPPORTED_SPC_PATTERN)
        }
    }

    fun toDomain(userId: Long): PlaylistCreation {
        return PlaylistCreation(
            userId = userId,
            title = title,
            content = content,
            songs = songs.map { it.toDomain() },
            hashtags = hashtags,
            image = image
        )
    }
}
