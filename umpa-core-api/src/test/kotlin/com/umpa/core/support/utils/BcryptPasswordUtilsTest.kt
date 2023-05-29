package com.umpa.core.support.utils

import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test

internal class BcryptPasswordUtilsTest {
    @Test
    fun `bcrypt를 통해 암호화한다`() {
        val plain = "umpa123"
        val actual = BcryptPasswordUtils.encode(plain)
        println(actual)
    }

    @Test
    fun `다른 암호가 들어오면 match가 되지 않는다`() {
        val raw = "umpa123"
        val sut = "\$2b\$10\$JQy1O8tO8IxfFoC7F3kTEu8q5X.z53jciy1de/fO66GhiFFwqZI2a"
        val actual = BcryptPasswordUtils.match(raw, sut)
        Assertions.assertThat(actual).isTrue()
    }
}
