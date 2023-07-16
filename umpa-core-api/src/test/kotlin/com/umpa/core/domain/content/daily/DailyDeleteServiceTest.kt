package com.umpa.core.domain.content.daily

import com.umpa.core.fixtures.domains.content.daily.DailyBuilder
import com.umpa.core.support.exceptions.CoreApiException
import com.umpa.core.support.exceptions.ErrorType
import io.kotest.matchers.shouldBe
import io.mockk.every
import io.mockk.mockk
import io.mockk.verify
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

internal class DailyDeleteServiceTest {
    private val dailyReader = mockk<DailyReader>()
    private val dailyDeleter = mockk<DailyDeleterWrapper>()
    private val sut = DailyDeleteService(dailyReader, dailyDeleter)
    private val daily = DailyBuilder().build()

    @Test
    fun `내 데일리만 삭제할 수 있다`() {
        every { dailyReader.readById(any()) } returns daily
        every { dailyDeleter.delete(any()) } returns Unit

        sut.delete(daily.id, daily.userId)

        verify(exactly = 1) { dailyDeleter.delete(any()) }
    }

    @Test
    fun `다른 유저의 데일리를 삭제할 수 없다`() {
        every { dailyReader.readById(any()) } returns daily

        val exception = assertThrows<CoreApiException> {
            sut.delete(daily.id, 1L)
        }

        exception.errorType shouldBe ErrorType.FORBIDDEN_DELETE_DAILY
    }
}
