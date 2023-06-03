package com.umpa.core.controller.v1.content.playlist.request

import com.umpa.core.domain.content.playlist.PlaylistCreation
import org.springframework.web.multipart.MultipartFile

data class PlaylistCreateRequest(
    val title: String,
    val content: String,
//    val songs: List<>,
    val hashTags: List<String>,
    val image: MultipartFile?
) {
    fun toDomain(userId: Long): PlaylistCreation {
        return PlaylistCreation(
            userId = userId,
            title = title,
            content = content,
            hashTags = hashTags,
            image = image
        )
    }
}
