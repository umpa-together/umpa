package com.umpa.core.domain.user

import com.umpa.core.fixtures.domains.user.UserBuilder
import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Test

class UserTest {
    @Test
    fun `유저 프로필을 반환한다`() {
        val user = UserBuilder().build()

        val actual = user.profile()

        actual.id shouldBe user.id
        actual.nickName shouldBe user.nickName
        actual.profileImage shouldBe user.profileImage
    }

    @Test
    fun `유저 프로필 디테일을 반환한다`() {
        val user = UserBuilder().build()

        val actual = user.profileDetail()

        actual.id shouldBe user.id
        actual.nickName shouldBe user.nickName
        actual.profileImage shouldBe user.profileImage
        actual.introduction shouldBe user.introduction
        actual.backgroundImage shouldBe user.backgroundImage
        actual.realName shouldBe user.realName
    }
}
