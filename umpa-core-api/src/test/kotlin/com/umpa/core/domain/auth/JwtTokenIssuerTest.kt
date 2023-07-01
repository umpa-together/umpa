package com.umpa.core.domain.auth

import com.umpa.core.support.exceptions.CoreApiException
import com.umpa.core.support.exceptions.ErrorType
import io.jsonwebtoken.io.Decoders
import io.jsonwebtoken.security.Keys
import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import javax.crypto.SecretKey

internal class JwtTokenIssuerTest {
    private lateinit var key: SecretKey
    private lateinit var sut: JwtTokenHandler
    private val userId = 1L

    @BeforeEach
    fun setup() {
        key = Keys.hmacShaKeyFor(Decoders.BASE64.decode("testtesttesttesttesttesttesttesttesttesttesttest"))
        sut = JwtTokenHandler(key)
    }

    @Test
    fun `token을 발급 받는다`() {
        val actual = sut.issue(userId)
        println(actual)
    }

    @Test
    fun `잘못된 token을 decode하면 예외를 던진다`() {
        val exception = assertThrows<CoreApiException> {
            sut.decode(
                "eyJhbGciOiJIUzI1NiJ9.eyJ1c2VySWQiOjEsImlhdCI6MTY4NjQ3Mzk4OCwiZXhwIjoxNjg2NTYwMzg4fQ.LiQtyRzL01eCTA0e6xnTKkoZrHVlmdbxPVITUiksAgE"
            )
        }
        exception.errorType shouldBe ErrorType.INVALID_TOKEN
    }

    @Test
    fun `토큰을 decode 했을 때 올바른 body를 얻는다`() {
        val actual = sut.decode(
            "eyJhbGciOiJIUzI1NiJ9.eyJ1c2VySWQiOjEsImlhdCI6MTY4ODE4MTA3MywiZXhwIjoxNjg4MjY3NDczfQ.sQc0TrN73kXwwWUimgDC4vkAUNXsi707pjCWz04KYq0"
        )
        val tokenUserId = actual["userId"]
        tokenUserId shouldBe userId
    }
}
