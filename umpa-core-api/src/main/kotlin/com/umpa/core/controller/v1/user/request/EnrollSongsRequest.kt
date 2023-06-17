package com.umpa.core.controller.v1.user.request

import com.umpa.core.controller.v1.spotiffy.request.TrackRequest
import com.umpa.core.domain.user.UserSongCreation

data class EnrollSongsRequest(
    val songs: List<TrackRequest>
) {
    fun toUserSongCreation(userId: Long): UserSongCreation {
        return UserSongCreation(
            userId = userId,
            songs = songs.map { it.toDomain() }
        )
    }
}
