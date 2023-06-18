package com.umpa.core.domain.content.playlist

import org.springframework.stereotype.Service
import org.springframework.web.multipart.MultipartFile

@Service
class PlaylistCreateService(
    private val playlistCreator: PlaylistCreatorWrapper
) {
    fun create(creation: PlaylistCreation): PlaylistDetail {
        val playlist = playlistCreator.create(creation)

        // TODO 이미지 업로드
//        creation.image?.let {
//            val uploadedImageUrl = imageUploadAndUpdate(it)
//            savedPlaylist.uploadImage(uploadedImageUrl)
//        }

        return PlaylistDetail(
            playlist = playlist,
            songs = creation.songs,
            hashtags = creation.hashtags,
            comments = emptyList()
        )
    }

    private fun imageUploadAndUpdate(image: MultipartFile): String {
        return "url"
    }
}
