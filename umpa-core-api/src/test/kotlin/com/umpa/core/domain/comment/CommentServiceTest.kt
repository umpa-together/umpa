package com.umpa.core.domain.comment

import com.umpa.core.fixtures.domains.comment.CommentRemovalBuilder
import com.umpa.core.fixtures.entity.comment.CommentEntityBuilder
import com.umpa.core.support.exceptions.CoreApiException
import com.umpa.core.support.exceptions.ErrorType
import io.kotest.matchers.shouldBe
import io.mockk.every
import io.mockk.mockk
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource

internal class CommentServiceTest {
    private val commentCreator = mockk<CommentCreator>()
    private val commentReader = mockk<CommentReader>()
    private val commentUpdater = mockk<CommentUpdater>()
    private val sut = CommentService(commentCreator, commentReader, commentUpdater)

    @ParameterizedTest
    @CsvSource(
        "1,0,,FORBIDDEN_CONTENT_ID",
        "0,1,,FORBIDDEN_USER_ID",
        "0,0,0,FORBIDDEN_PARENT_COMMENT_ID"
    )
    fun `comment 제거할 때, removal 검증에 실패하면 에러가 발생한다`(contentId: Long, userId: Long, parentCommentId: Long?, errorType: ErrorType) {
        val removal = CommentRemovalBuilder(
            parentCommentId = parentCommentId
        ).build()
        val commentEntity = CommentEntityBuilder(
            contentId = contentId,
            userId = userId,
            parentCommentId = parentCommentId?.inc()
        ).build()

        every { commentReader.readById(any()) } returns commentEntity

        val exception = assertThrows<CoreApiException> { sut.remove(removal) }

        exception.errorType shouldBe errorType
    }
}
