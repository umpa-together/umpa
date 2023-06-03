package com.umpa.core.domain.content.playlist

import com.umpa.playlist.PlaylistEntity
import com.umpa.playlist.PlaylistRepository
import jakarta.transaction.Transactional
import org.springframework.stereotype.Component
import org.springframework.web.multipart.MultipartFile

@Component
class PlaylistCreator(
    private val repository: PlaylistRepository
) {
    @Transactional
    fun create(creation: PlaylistCreation): PlaylistEntity {
        val savedPlaylist = repository.save(
            creation.toEntity()
        )
        creation.image?.let {
            val uploadedImageUrl = imageUploadAndUpdate(it)
            savedPlaylist.uploadImage(uploadedImageUrl)
        }
        return savedPlaylist
    }

    private fun imageUploadAndUpdate(image: MultipartFile): String {
        return "url"
    }
}
