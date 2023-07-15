package com.umpa.core.domain.follow

import com.umpa.core.fixtures.domains.follow.FollowEntityBuilder
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
        val followingUsers = listOf(
            FollowEntityBuilder().build(),
            FollowEntityBuilder().build(),
            FollowEntityBuilder().build()
        )

        val followerUsers = listOf(
            FollowEntityBuilder().build(),
            FollowEntityBuilder().build(),
            FollowEntityBuilder().build(),
            FollowEntityBuilder().build(),
            FollowEntityBuilder().build()
        )

        every { repository.findByFollowingUserIdAndActiveIsTrue(any()) } returns followingUsers
        every { repository.findByFollowerUserIdAndActiveIsTrue(any()) } returns followerUsers

        val actual = sut.readFollowShipCountByUserId(0L)

        actual.followingUserIds.size shouldBe followingUsers.size
        actual.followerUserIds.size shouldBe followerUsers.size
    }
}
