package com.umpa.core.domain.content.playlist

import com.umpa.core.fixtures.domains.content.playlist.PlaylistBuilder
import com.umpa.core.fixtures.domains.content.playlist.PlaylistDetailBuilder
import io.kotest.matchers.shouldBe
import io.mockk.every
import io.mockk.mockk
import io.mockk.verify
import org.junit.jupiter.api.Test

class PlaylistReadServiceTest {
    private val playlistReader = mockk<PlaylistReader>()
    private val playlistDetailFiller = mockk<PlaylistDetailFiller>()
    private val playlistUpdater = mockk<PlaylistUpdater>()
    private val sut = PlaylistReadService(playlistReader, playlistDetailFiller, playlistUpdater)

    @Test
    fun `플레이리스트 조회시 플레이리스트 디테일을 잘 반환한다`() {
        val playlist = PlaylistBuilder().build()
        val playlistDetail = PlaylistDetailBuilder(playlist = playlist).build()

        every { playlistReader.readById(any()) } returns playlist
        every { playlistDetailFiller.fill(any()) } returns playlistDetail

        val actual = sut.readById(playlist.id, playlist.userId)

        actual shouldBe playlistDetail
    }

    @Test
    fun `다른 사람의 플레이리스트 조회시 viewCount를 증가시킨다`() {
        val playlist = PlaylistBuilder().build()

        every { playlistReader.readById(any()) } returns playlist
        every { playlistUpdater.increaseViewCount(any()) } returns Unit
        every { playlistDetailFiller.fill(any()) } returns PlaylistDetailBuilder().build()

        sut.readById(playlist.id, playlist.userId + 1L)

        verify(exactly = 1) { playlistUpdater.increaseViewCount(any()) }
    }
}
