package com.umpa.core.domain.hashtag

import com.umpa.core.fixtures.entity.hashtag.HashtagEntityBuilder
import com.umpa.storage.db.core.hashtag.HashtagRepository
import io.kotest.matchers.shouldBe
import io.mockk.every
import io.mockk.mockk
import org.junit.jupiter.api.Test

class HashtagReaderTest {
    private val hashtagRepository = mockk<HashtagRepository>()
    private val sut = HashtagReader(hashtagRepository)

    @Test
    fun `contentId에 맞는 제거되지 않은 해시태그를 조회한다`() {
        val hashtagEntities = listOf(
            HashtagEntityBuilder(hashtag = "hashtag1").build(),
            HashtagEntityBuilder(hashtag = "hashtag2").build(),
            HashtagEntityBuilder(hashtag = "hashtag3").build()
        )

        every { hashtagRepository.findAllByContentIdAndIsDeletedIsFalse(any()) } returns hashtagEntities

        val actual = sut.readByContentId(0L)

        actual.size shouldBe hashtagEntities.size
    }
}
