package com.umpa.core.domain.follow

import com.umpa.storage.db.core.follow.FollowRepository
import io.kotest.matchers.shouldBe
import io.mockk.every
import io.mockk.mockk
import org.junit.jupiter.api.Test

internal class FollowReaderTest {
    private val repository = mockk<FollowRepository>()
    private val sut = FollowReader(repository)

    @Test
    fun `userId를 기준으로 팔로우, 팔로잉한 유저수를 반환한다`() {
        val followingCount = 3L
        val followerCount = 5L

        every { repository.countByFollowingUserIdAndActiveIsTrue(any()) } returns followingCount
        every { repository.countByFollowerUserIdAndActiveIsTrue(any()) } returns followerCount

        val actual = sut.getFollowShipCountByUserId(0L)

        actual.followerUserCount shouldBe followerCount
        actual.followingUserCount shouldBe  followingCount
    }
}
