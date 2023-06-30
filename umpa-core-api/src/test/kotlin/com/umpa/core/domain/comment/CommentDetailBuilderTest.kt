package com.umpa.core.domain.comment

import com.umpa.core.fixtures.domains.comment.CommentBuilder
import com.umpa.core.fixtures.domains.user.UserBuilder
import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Test

class CommentDetailBuilderTest {
    private val sut = CommentDetailBuilder

    @Test
    fun `대댓글이 없는 경우 댓글만 반환한다`() {
        val comments = listOf(
            CommentBuilder().build(),
            CommentBuilder(userId = 1L).build(),
            CommentBuilder(userId = 1L).build(),
            CommentBuilder().build()
        )
        val users = listOf(
            UserBuilder().build(),
            UserBuilder(id = 1).build()
        )

        val actual = sut.build(comments, users)

        actual.forEach {
            it.reComments.size shouldBe 0
        }
    }

    @Test
    fun `대댓글은 해당 부모 댓글에 합쳐진다`() {
        val comments = listOf(
            CommentBuilder(id = 1).build(),
            CommentBuilder(userId = 1L, parentCommentId = 1L).build(),
            CommentBuilder(id = 2, userId = 1L).build(),
            CommentBuilder(parentCommentId = 1L).build()
        )
        val users = listOf(
            UserBuilder().build(),
            UserBuilder(id = 1).build()
        )

        val actual = sut.build(comments, users)

        actual[0].id shouldBe 1L
        actual[0].reComments.size shouldBe 2
        actual[1].reComments.size shouldBe 0
    }

    @Test
    fun `댓글을 작성한 유저의 프로필이 세팅된다`() {
        val comments = listOf(
            CommentBuilder(id = 1, userId = 2L).build(),
            CommentBuilder(id = 2, userId = 1L).build(),
        )
        val users = listOf(
            UserBuilder(id = 1L, nickName = "firstUser").build(),
            UserBuilder(id = 2L, nickName = "secondUser").build()
        )

        val actual = sut.build(comments, users)

        actual[0].id shouldBe comments[0].id
        actual[0].userProfile.id shouldBe users[1].id
        actual[0].userProfile.nickName shouldBe users[1].nickName
        actual[1].id shouldBe comments[1].id
        actual[1].userProfile.id shouldBe users[0].id
        actual[1].userProfile.nickName shouldBe users[0].nickName
    }
}
