package com.umpa.core.domain.content.playlist

import com.umpa.core.domain.user.UserReader
import org.springframework.stereotype.Service
import org.springframework.web.multipart.MultipartFile

@Service
class PlaylistCreateService(
    private val playlistCreator: PlaylistCreatorWrapper,
    private val userReader: UserReader,
    private val playlistUpdater: PlaylistUpdaterWrapper,
    private val playlistDetailFiller: PlaylistDetailFiller
) {
    fun create(creation: PlaylistCreation): PlaylistDetail {
        val playlist = playlistCreator.create(creation)
        val user = userReader.readById(playlist.userId)
        // TODO 이미지 업로드
//        creation.image?.let {
//            val uploadedImageUrl = imageUploadAndUpdate(it)
//            savedPlaylist.uploadImage(uploadedImageUrl)
//        }

        return PlaylistDetail(
            playlist = playlist,
            postUser = user,
            songs = creation.songs,
            hashtags = creation.hashtags,
            comments = emptyList()
        )
    }

    private fun imageUploadAndUpdate(image: MultipartFile): String {
        return "url"
    }

    fun edit(revision: PlaylistRevision): PlaylistDetail {
        val playlist = playlistUpdater.edit(revision)
        return playlistDetailFiller.fill(playlist)
    }
}
