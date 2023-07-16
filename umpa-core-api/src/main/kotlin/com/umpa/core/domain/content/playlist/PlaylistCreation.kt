package com.umpa.core.domain.content.playlist

import com.umpa.commons.enums.ContentType
import com.umpa.core.domain.feed.FeedCreation
import com.umpa.core.domain.hashtag.HashtagCreation
import com.umpa.core.domain.song.SongCreation
import com.umpa.core.domain.song.spotify.Track
import com.umpa.storage.db.core.playlist.PlaylistEntity
import org.springframework.web.multipart.MultipartFile

data class PlaylistCreation(
    val userId: Long,
    val title: String,
    val content: String,
    val songs: List<Track>,
    val hashtags: List<String>,
    val image: MultipartFile?
) {
    fun toEntity(): PlaylistEntity {
        return PlaylistEntity(
            userId = userId,
            title = title,
            content = content
        )
    }

    fun toSongCreations(contentId: Long, contentType: ContentType): List<SongCreation> {
        return songs.map {
            SongCreation(
                userId = userId,
                contentId = contentId,
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

    fun toFeedCreation(contentId: Long, contentType: ContentType): FeedCreation {
        return FeedCreation(
            userId = userId,
            contentId = contentId,
            contentType = contentType
        )
    }

    fun toHashtagCreations(contentId: Long): List<HashtagCreation> {
        return hashtags.map {
            HashtagCreation(
                hashtag = it,
                contentId = contentId
            )
        }
    }
}
