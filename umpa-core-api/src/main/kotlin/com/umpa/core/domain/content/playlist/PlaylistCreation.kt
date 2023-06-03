package com.umpa.core.domain.content.playlist

import com.umpa.playlist.PlaylistEntity
import org.springframework.web.multipart.MultipartFile

data class PlaylistCreation(
    val userId: Long,
    val title: String,
    val content: String,
//    val songs: List<>,
    val hashTags: List<String>,
    val image: MultipartFile?
) {
    fun toEntity(): PlaylistEntity {
        return PlaylistEntity(
            userId = userId,
            title = title,
            content = content
        )
    }
}
