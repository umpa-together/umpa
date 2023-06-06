package com.umpa.core.support.utils

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class PatternUtilsTest {
    private val sut = PatternUtils

    @Test
    fun `특수문자를 포함하면 false를 반환한다`() {
        val text = "$12"
        val actual = sut.isKorAndEngAndNumAndNotSpc(text)
        assertThat(actual).isEqualTo(false)
    }
}
