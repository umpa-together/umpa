package com.umpa.core.domain.content

import com.umpa.core.domain.content.playlist.UserPlaylistReader
import org.springframework.stereotype.Component

@Component
class UserContentReader(
    private val userPlaylistReader: UserPlaylistReader
) {
    fun readByUserId(userId: Long): UserContentDetail {
        // contents ( playlist + daily + relay )
        val playlistDetail = userPlaylistReader.readByUserId(userId)
        return UserContentDetail(playlistDetail)
    }
}
