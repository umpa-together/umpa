package com.umpa.core.domain.follow

import com.umpa.core.fixtures.domains.follow.FollowShipBuilder
import com.umpa.core.support.exceptions.CoreApiException
import com.umpa.core.support.exceptions.ErrorType
import io.kotest.matchers.shouldBe
import io.mockk.every
import io.mockk.mockk
import io.mockk.verify
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

internal class FollowServiceTest {
    private val followValidator = mockk<FollowValidator>()
    private val followCreator = mockk<FollowCreator>()
    private val followUpdater = mockk<FollowUpdater>()
    private val sut = FollowService(followValidator, followCreator, followUpdater)

    @Test
    fun `팔로우 호출시, 엔티티가 정상적으로 저장된다`() {
        val followShip = FollowShipBuilder().build()

        every { followValidator.validateFollow(any()) } returns Unit
        every { followCreator.create(any()) } returns Unit

        sut.follow(followShip)

        verify(exactly = 1) { followValidator.validateFollow(any()) }
        verify(exactly = 1) { followCreator.create(any()) }
    }

    @Test
    fun `이미 팔로우를 하고 있을 때, 팔로우 호출시 에러를 반환한다`() {
        val followShip = FollowShipBuilder().build()

        every { followValidator.validateFollow(any()) } throws CoreApiException(ErrorType.FORBIDDEN_FOLLOW)

        val exception = assertThrows<CoreApiException> {
            sut.follow(followShip)
        }

        exception.errorType shouldBe ErrorType.FORBIDDEN_FOLLOW
    }

    @Test
    fun `언팔로우 호출시, 엔티티가 정상적으로 업데이트 된다`() {
        val followShip = FollowShipBuilder().build()

        every { followValidator.validateUnFollow(any()) } returns Unit
        every { followUpdater.unfollow(any()) } returns Unit

        sut.unfollow(followShip)

        verify(exactly = 1) { followValidator.validateUnFollow(any()) }
        verify(exactly = 1) { followUpdater.unfollow(any()) }
    }

    @Test
    fun `팔로우를 하고 있지 않을 때, 언팔로우 호출시 에러를 반환한다`() {
        val followShip = FollowShipBuilder().build()

        every { followValidator.validateUnFollow(any()) } throws CoreApiException(ErrorType.FORBIDDEN_UNFOLLOW)

        val exception = assertThrows<CoreApiException> {
            sut.unfollow(followShip)
        }

        exception.errorType shouldBe ErrorType.FORBIDDEN_UNFOLLOW
    }
}
