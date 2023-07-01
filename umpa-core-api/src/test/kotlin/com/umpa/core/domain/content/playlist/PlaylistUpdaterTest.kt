package com.umpa.core.domain.content.playlist

import com.umpa.core.fixtures.domains.content.playlist.PlaylistBuilder
import com.umpa.core.fixtures.domains.content.playlist.PlaylistRevisionBuilder
import com.umpa.core.fixtures.entity.content.playlist.PlaylistEntityBuilder
import com.umpa.storage.db.core.playlist.PlaylistRepository
import io.kotest.matchers.shouldBe
import io.mockk.every
import io.mockk.mockk
import org.junit.jupiter.api.Test
import org.springframework.data.repository.findByIdOrNull

class PlaylistUpdaterTest {
    private val playlistRepository = mockk<PlaylistRepository>()
    private val sut = PlaylistUpdater(playlistRepository)

    @Test
    fun `플레이리스트 수정시 title과 content를 수정한다`() {
        val revision = PlaylistRevisionBuilder(title = "title", content = "content").build()
        val playlist = PlaylistBuilder(title = revision.title, content = revision.content).build()

        every { playlistRepository.findByIdOrNull(any()) } returns PlaylistEntityBuilder().build()

        val actual = sut.edit(revision)

        actual.title shouldBe playlist.title
        actual.content shouldBe playlist.content
    }
}
