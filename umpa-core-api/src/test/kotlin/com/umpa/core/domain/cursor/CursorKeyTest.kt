package com.umpa.core.domain.cursor

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource

internal class CursorKeyTest {
    @ParameterizedTest
    @CsvSource(
        "MjA6MA==,20,0",
        "bnVsbDow,,0",
        "MjA6bnVsbA==,20,",
        "bnVsbDpudWxs,,"
    )
    fun `각 limit, offset에 맞는 CursorKey를 반환한다`(key: String, limit: Int?, offset: Int?) {
        val cursorKey = CursorKey.fromBase64(key)
        assertThat(cursorKey.limit).isEqualTo(limit)
        assertThat(cursorKey.offset).isEqualTo(offset)
    }

    @Test
    fun `cursorKey를 조회한다`() {
        val limit = null
        val offset = null
        val cursorKey = CursorKey(limit, offset)
        println(cursorKey.encode())
    }

    @Test
    fun `url에서 limit, offset을 찾아 cursorKey를 만든다`() {
        val url = """
            https://api.spotify.com/v1/search?query=ap+alchemy&type=track&locale=ko-KR%2Cko%3Bq%3D0.9%2Cen-US%3Bq%3D0.8%2Cen%3Bq%3D0.7&offset=3&limit=3
        """.trimIndent()
        val sut = CursorKey.extractFromUrl(url)
        assertThat(sut.limit).isEqualTo(3)
        assertThat(sut.offset).isEqualTo(3)
    }
}
