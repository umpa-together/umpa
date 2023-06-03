package com.umpa.core.domain.user

import com.umpa.core.support.exceptions.CoreApiException
import com.umpa.core.support.exceptions.ErrorType
import io.mockk.every
import io.mockk.mockk
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

internal class UserCreateServiceTest {
    private val validator = mockk<UserValidator>()
    private val creator = mockk<UserCreator>()
    private val sut = UserCreateService(validator, creator)

    @Test
    fun `동일한 이메일이 존재하면 예외가 발생한다`() {
        val credential = UserCredential("", "")
        every { validator.validateDuplicateByEmail(any()) } throws CoreApiException(ErrorType.ALREADY_EXISTS_EMAIL)

        assertThrows<CoreApiException> {
            sut.create(credential)
        }
    }
}
