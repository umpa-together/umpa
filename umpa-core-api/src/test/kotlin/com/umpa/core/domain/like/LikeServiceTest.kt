package com.umpa.core.domain.like

import com.umpa.core.fixtures.entity.like.LikeEntityBuilder
import com.umpa.core.support.exceptions.CoreApiException
import com.umpa.core.support.exceptions.ErrorType
import io.kotest.matchers.shouldBe
import io.mockk.every
import io.mockk.mockk
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

internal class LikeServiceTest {
    private val likeCreator = mockk<LikeCreator>()
    private val likeReader = mockk<LikeReader>()
    private val likeUpdater = mockk<LikeUpdater>()
    private val sut = LikeService(likeCreator, likeReader, likeUpdater)

    @Test
    fun `내가 좋아요한 컨텐츠가 아니면 좋아요 취소시 예외가 발생한다`() {
        every { likeReader.readById(any()) } returns LikeEntityBuilder().build()

        val exception = assertThrows<CoreApiException> {
            sut.unlike(0L, 1L)
        }

        exception.errorType shouldBe ErrorType.FORBIDDEN_UNLIKE
    }
}
