package com.umpa.core.domain.content.daily

import com.umpa.core.fixtures.domains.content.daily.DailyBuilder
import com.umpa.core.fixtures.domains.content.daily.DailyDetailBuilder
import io.kotest.matchers.shouldBe
import io.mockk.every
import io.mockk.mockk
import io.mockk.verify
import org.junit.jupiter.api.Test

internal class DailyReadServiceTest {
    private val dailyReader = mockk<DailyReader>()
    private val dailyUpdater = mockk<DailyUpdater>()
    private val dailyDetailFiller = mockk<DailyDetailFiller>()
    private val sut = DailyReadService(dailyReader, dailyUpdater, dailyDetailFiller)

    @Test
    fun `데일리 조회시 데일리 디테일을 잘 반환한다`() {
        val daily = DailyBuilder().build()
        val dailyDetail = DailyDetailBuilder(daily = daily).build()

        every { dailyReader.readById(any()) } returns daily
        every { dailyDetailFiller.fill(any()) } returns dailyDetail

        val actual = sut.readById(daily.id, daily.userId)

        actual shouldBe dailyDetail
    }

    @Test
    fun `다른 사람의 데일리 조회시 viewCount를 증가시킨다`() {
        val daily = DailyBuilder().build()

        every { dailyReader.readById(any()) } returns daily
        every { dailyUpdater.increaseViewCount(any()) } returns Unit
        every { dailyDetailFiller.fill(any()) } returns DailyDetailBuilder().build()

        sut.readById(daily.id, daily.userId + 1L)

        verify(exactly = 1) { dailyUpdater.increaseViewCount(any()) }
    }
}
