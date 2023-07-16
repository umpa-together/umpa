package com.umpa.core.domain.content.daily

import com.umpa.core.fixtures.domains.content.daily.DailyBuilder
import com.umpa.core.fixtures.domains.content.daily.DailyDetailBuilder
import com.umpa.core.fixtures.domains.content.daily.DailyRevisionBuilder
import com.umpa.core.support.exceptions.CoreApiException
import com.umpa.core.support.exceptions.ErrorType
import io.kotest.matchers.shouldBe
import io.mockk.every
import io.mockk.mockk
import io.mockk.verify
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

internal class DailyUpdateServiceTest {
    private val dailyReader = mockk<DailyReader>()
    private val dailyUpdater = mockk<DailyUpdaterWrapper>()
    private val dailyDetailFiller = mockk<DailyDetailFiller>()
    private val sut = DailyUpdateService(dailyReader, dailyUpdater, dailyDetailFiller)

    @Test
    fun `내 데일리만 수정할 수 있다`() {
        val revision = DailyRevisionBuilder().build()
        val daily = DailyBuilder(id = revision.id, userId = revision.userId).build()
        val dailyDetail = DailyDetailBuilder(daily = daily).build()

        every { dailyReader.readById(any()) } returns daily
        every { dailyUpdater.edit(any()) } returns daily
        every { dailyDetailFiller.fill(any()) } returns dailyDetail

        val actual = sut.edit(revision)

        actual shouldBe dailyDetail

        verify(exactly = 1) { dailyUpdater.edit(any()) }
    }

    @Test
    fun `다른 사람의 데일리를 수정할 시 에러를 반환한다`() {
        val revision = DailyRevisionBuilder().build()
        val daily = DailyBuilder(id = revision.id, userId = revision.userId + 1).build()

        every { dailyReader.readById(any()) } returns daily

        val exception = assertThrows<CoreApiException> {
            sut.edit(revision)
        }

        exception.errorType shouldBe ErrorType.FORBIDDEN_EDIT_DAILY
    }
}
