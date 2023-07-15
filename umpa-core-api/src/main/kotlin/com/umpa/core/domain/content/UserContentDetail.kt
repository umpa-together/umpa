package com.umpa.core.domain.content

import com.umpa.core.domain.content.playlist.UserPlaylistDetail

data class UserContentDetail(
    val playlists: List<UserPlaylistDetail>
)
