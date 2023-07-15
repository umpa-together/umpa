package com.umpa.core.domain.content

import com.umpa.core.fixtures.domains.content.playlist.PlaylistBuilder
import com.umpa.core.fixtures.entity.song.SongEntityBuilder
import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Test

class ContentAndSongAggregatorTest {
    private val sut = ContentAndSongAggregator

    @Test
    fun `플레이리스트 목록과 곡 목록이 주어졌을 때 UserPlaylistDetail 목록을 잘 반환한다`() {
        val playlists = listOf(
            PlaylistBuilder(id = 1, imageUrl = "image").build(),
            PlaylistBuilder(id = 2).build(),
            PlaylistBuilder(id = 3).build()
        )
        val songs = listOf(
            SongEntityBuilder(contentId = 1L).build(),
            SongEntityBuilder(contentId = 1L).build(),
            SongEntityBuilder(contentId = 2L).build(),
            SongEntityBuilder(contentId = 2L).build(),
            SongEntityBuilder(contentId = 2L).build(),
            SongEntityBuilder(contentId = 3L).build()
        )

        val actual = sut.aggregate(playlists, songs)

        actual.size shouldBe 3
        actual[0].songCount shouldBe 2
        actual[1].songCount shouldBe 3
        actual[2].songCount shouldBe 1
        actual[0].hasImage shouldBe true
        actual[0].imageUrl shouldBe playlists[0].imageUrl
        actual[1].hasImage shouldBe false
    }
}
