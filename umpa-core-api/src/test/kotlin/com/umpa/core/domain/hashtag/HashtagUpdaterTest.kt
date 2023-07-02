package com.umpa.core.domain.hashtag

import com.umpa.core.fixtures.domains.hashtag.HashtagCreationBuilder
import com.umpa.core.fixtures.entity.hashtag.HashtagEntityBuilder
import com.umpa.storage.db.core.hashtag.HashtagRepository
import io.kotest.matchers.shouldBe
import io.mockk.every
import io.mockk.mockk
import io.mockk.verify
import org.junit.jupiter.api.Test

class HashtagUpdaterTest {
    private val hashtagRepository = mockk<HashtagRepository>()
    private val hashtagCreator = mockk<HashtagCreator>()
    private val sut = HashtagUpdater(hashtagRepository, hashtagCreator)
    private val hashtags = listOf(
        HashtagEntityBuilder(hashtag = "test1").build(),
        HashtagEntityBuilder(hashtag = "test2").build(),
        HashtagEntityBuilder(hashtag = "test3").build()
    )

    @Test
    fun `등록된 해시태그를 삭제하고 새롭게 create하지 않는다`() {
        val hashtagCreations = listOf(
            HashtagCreationBuilder(hashtag = "test1").build(),
            HashtagCreationBuilder(hashtag = "test2").build()
        )

        every { hashtagRepository.findAllByContentIdAndIsDeletedIsFalse(any()) } returns hashtags

        sut.edit(0L, hashtagCreations)

        hashtags[2].isDeleted shouldBe true
        verify(exactly = 0) { hashtagCreator.create(any()) }
    }

    @Test
    fun `등록된 해스태그를 삭제하고 새롭게 create 한다`() {
        val hashtagCreations = listOf(
            HashtagCreationBuilder(hashtag = "test2").build(),
            HashtagCreationBuilder(hashtag = "test4").build(),
            HashtagCreationBuilder(hashtag = "test5").build()
        )

        every { hashtagRepository.findAllByContentIdAndIsDeletedIsFalse(any()) } returns hashtags
        every { hashtagCreator.create(any()) } returns Unit

        sut.edit(0L, hashtagCreations)

        hashtags.map { it.isDeleted }.filter { it }.size shouldBe 2
        verify(exactly = 1) { hashtagCreator.create(any()) }
    }
}
