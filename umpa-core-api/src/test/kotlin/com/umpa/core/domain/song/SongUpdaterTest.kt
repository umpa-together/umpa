package com.umpa.core.domain.song

import com.umpa.core.fixtures.domains.song.SongCreationBuilder
import com.umpa.core.fixtures.entity.song.SongEntityBuilder
import com.umpa.storage.db.core.song.SongRepository
import io.kotest.matchers.shouldBe
import io.mockk.every
import io.mockk.mockk
import io.mockk.verify
import org.junit.jupiter.api.Test

class SongUpdaterTest {
    private val songRepository = mockk<SongRepository>()
    private val songCreator = mockk<SongCreator>()
    private val sut = SongUpdater(songRepository, songCreator)
    private val songs = listOf(
        SongEntityBuilder(spotifyTrackId = "1").build(),
        SongEntityBuilder(spotifyTrackId = "2").build(),
        SongEntityBuilder(spotifyTrackId = "3").build(),
        SongEntityBuilder(spotifyTrackId = "4").build()
    )

    @Test
    fun `등록된 컨텐츠의 곡을 삭제하고 새롭게 create하지 않는다`() {
        val songCreations = listOf(
            SongCreationBuilder(id = "1").build(),
            SongCreationBuilder(id = "2").build(),
            SongCreationBuilder(id = "3").build()
        )

        every { songRepository.findAllByContentIdAndIsDeletedIsFalse(any()) } returns songs

        sut.edit(0L, songCreations)

        songs[3].isDeleted shouldBe true
        verify(exactly = 0) { songCreator.create(any()) }
    }

    @Test
    fun `등록된 컨텐츠의 곡을 삭제하고, 새로운 곡을 추가한다`() {
        val songCreations = listOf(
            SongCreationBuilder(id = "1").build(),
            SongCreationBuilder(id = "2").build(),
            SongCreationBuilder(id = "5").build(),
            SongCreationBuilder(id = "6").build()
        )

        every { songRepository.findAllByContentIdAndIsDeletedIsFalse(any()) } returns songs
        every { songCreator.create(any()) } returns Unit

        sut.edit(0L, songCreations)

        songs.map { it.isDeleted }.filter { it }.size shouldBe 2
        verify(exactly = 1) { songCreator.create(any()) }
    }
}
