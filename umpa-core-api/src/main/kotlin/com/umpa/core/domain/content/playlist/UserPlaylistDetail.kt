package com.umpa.core.domain.content.playlist

import com.umpa.core.domain.song.spotify.Track
import java.time.LocalDateTime

// TODO delay, relay-playlist까지 나오면 인터페이스 구현하는 방향으로 수정
data class UserPlaylistDetail(
    val id: Long,
    val title: String,
    val hasImage: Boolean,
    val imageUrl: String?,
    val trackImages: List<String>,
    val createdAt: LocalDateTime,
    val viewCount: Long,
    val representSong: Track,
    val songCount: Int
)
