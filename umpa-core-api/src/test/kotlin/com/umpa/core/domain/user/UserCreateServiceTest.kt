package com.umpa.core.domain.user

import com.umpa.core.domain.auth.AccessTokenIssuer
import com.umpa.core.fixtures.domains.auth.TokenBucketBuilder
import com.umpa.core.fixtures.domains.user.UserCredentialBuilder
import com.umpa.core.fixtures.entity.user.UserEntityBuilder
import com.umpa.core.support.exceptions.CoreApiException
import com.umpa.core.support.exceptions.ErrorType
import io.kotest.matchers.shouldBe
import io.mockk.every
import io.mockk.mockk
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

internal class UserCreateServiceTest {
    private val userValidator = mockk<UserValidator>()
    private val userCreator = mockk<UserCreator>()
    private val tokenIssuer = mockk<AccessTokenIssuer>()
    private val sut = UserCreateService(userValidator, userCreator, tokenIssuer)

    @Test
    fun `회원가입이 정상적으로 완료되면 토큰이 발급 된다`() {
        val credential = UserCredentialBuilder().build()
        val userEntity = UserEntityBuilder().build()
        val token = TokenBucketBuilder().build()

        every { userValidator.validateDuplicateByEmail(any()) } returns Unit
        every { userCreator.create(any()) } returns userEntity
        every { tokenIssuer.issue(any()) } returns token

        val actual = sut.create(credential)

        actual shouldBe token
    }

    @Test
    fun `동일한 이메일이 존재하면 예외가 발생한다`() {
        val credential = UserCredential("", "")
        every { userValidator.validateDuplicateByEmail(any()) } throws CoreApiException(ErrorType.ALREADY_EXISTS_EMAIL)

        assertThrows<CoreApiException> {
            sut.create(credential)
        }
    }
}
