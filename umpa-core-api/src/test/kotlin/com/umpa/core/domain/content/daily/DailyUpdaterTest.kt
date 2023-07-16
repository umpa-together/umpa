package com.umpa.core.domain.content.daily

import com.umpa.core.fixtures.domains.content.daily.DailyBuilder
import com.umpa.core.fixtures.domains.content.daily.DailyRevisionBuilder
import com.umpa.core.fixtures.entity.content.daily.DailyEntityBuilder
import com.umpa.storage.db.core.daily.DailyRepository
import io.kotest.matchers.shouldBe
import io.mockk.every
import io.mockk.mockk
import org.junit.jupiter.api.Test
import org.springframework.data.repository.findByIdOrNull

internal class DailyUpdaterTest {
    private val dailyRepository = mockk<DailyRepository>()
    private val sut = DailyUpdater(dailyRepository)

    @Test
    fun `데일리 수정시 content를 수정한다`() {
        val revision = DailyRevisionBuilder(content = "content").build()
        val daily = DailyBuilder(content = revision.content).build()

        every { dailyRepository.findByIdOrNull(any()) } returns DailyEntityBuilder().build()

        val actual = sut.edit(revision)

        actual.content shouldBe daily.content
    }

    @Test
    fun `데일리 삭제시 isDeleted를 true로 변경한다`() {
        val dailyEntity = DailyEntityBuilder().build()

        every { dailyRepository.findByIdOrNull(any()) } returns dailyEntity

        sut.delete(dailyEntity.id)

        dailyEntity.isDeleted shouldBe true
    }
}
