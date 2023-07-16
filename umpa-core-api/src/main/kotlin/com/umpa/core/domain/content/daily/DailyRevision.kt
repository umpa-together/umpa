package com.umpa.core.domain.content.daily

import com.umpa.commons.enums.ContentType
import com.umpa.core.domain.hashtag.HashtagCreation
import com.umpa.core.domain.song.SongCreation
import com.umpa.core.domain.song.spotify.Track

data class DailyRevision(
    val id: Long,
    val userId: Long,
    val content: String,
    val songs: List<Track>,
    val hashtags: List<String>
) {
    fun toSongCreations(contentType: ContentType): List<SongCreation> {
        return songs.map {
            SongCreation(
                userId = userId,
                contentId = id,
                id = it.id,
                name = it.name,
                artistNames = it.artistNames,
                albumImage = it.albumImage,
                isExplicit = it.isExplicit,
                previewUrl = it.previewUrl,
                contentType = contentType
            )
        }
    }

    fun toHashtagCreations(): List<HashtagCreation> {
        return hashtags.map {
            HashtagCreation(
                hashtag = it,
                contentId = id
            )
        }
    }
}
