package com.umpa.core.domain.auth

import com.umpa.core.domain.user.UserCredential
import com.umpa.core.domain.user.UserReader
import com.umpa.core.domain.user.UserValidator
import com.umpa.core.fixtures.user.UserEntityBuilder
import com.umpa.core.support.exceptions.CoreApiException
import com.umpa.core.support.exceptions.ErrorType
import io.mockk.every
import io.mockk.mockk
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

internal class AuthorizationServiceTest {
    private val reader = mockk<UserReader>()
    private val validator = mockk<UserValidator>()
    private val sut = AuthorizationService(reader, validator)

    @Test
    fun `동일한 이메일이 존재하지 않을 때 에러를 던진다`() {
        val credential = UserCredential("", "")

        every { reader.readByEmail(any()) } throws CoreApiException(ErrorType.NOT_FOUND_USER_EMAIL)

        assertThrows<CoreApiException> { sut.login(credential) }
    }

    @Test
    fun `비밀번호가 일치하지 않으면 에러를 던진다`() {
        val credential = UserCredential("", "")

        every { reader.readByEmail(any()) } returns UserEntityBuilder().build()
        every { validator.validatePassword(any(), any()) } throws CoreApiException(ErrorType.BAD_CREDENTIALS)

        assertThrows<CoreApiException> { sut.login(credential) }
    }
}
