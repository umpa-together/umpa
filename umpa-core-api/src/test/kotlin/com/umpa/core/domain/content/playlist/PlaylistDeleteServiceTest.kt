package com.umpa.core.domain.content.playlist

import com.umpa.core.fixtures.domains.content.playlist.PlaylistBuilder
import com.umpa.core.support.exceptions.CoreApiException
import com.umpa.core.support.exceptions.ErrorType
import io.kotest.matchers.shouldBe
import io.mockk.every
import io.mockk.mockk
import io.mockk.verify
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class PlaylistDeleteServiceTest {
    private val playlistReader = mockk<PlaylistReader>()
    private val playlistDeleter = mockk<PlaylistDeleterWrapper>()
    private val sut = PlaylistDeleteService(playlistReader, playlistDeleter)
    private val playlist = PlaylistBuilder().build()

    @Test
    fun `내 플레이리스트만 삭제할 수 있다`() {
        every { playlistReader.readById(any()) } returns playlist
        every { playlistDeleter.delete(any()) } returns Unit

        sut.delete(playlist.id, playlist.userId)

        verify(exactly = 1) { playlistDeleter.delete(any()) }
    }

    @Test
    fun `다른 유저의 플레이리스트를 삭제할 수 없다`() {
        every { playlistReader.readById(any()) } returns playlist

        val exception = assertThrows<CoreApiException> {
            sut.delete(playlist.id, 1L)
        }

        exception.errorType shouldBe ErrorType.FORBIDDEN_DELETE_PLAYLIST
    }
}
