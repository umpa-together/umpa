package com.umpa.core.domain.user

import com.umpa.commons.enums.ContentType
import com.umpa.core.domain.song.SongCreation
import com.umpa.core.domain.song.spotify.Track

data class UserSongCreation(
    val userId: Long,
    val songs: List<Track>
) {
    fun toSongCreations(): List<SongCreation> {
        return songs.map {
            SongCreation(
                userId = userId,
                id = it.id,
                name = it.name,
                artistNames = it.artistNames,
                albumImage = it.albumImage,
                isExplicit = it.isExplicit,
                previewUrl = it.previewUrl,
                contentType = ContentType.USER_REPRESENT
            )
        }
    }
}
