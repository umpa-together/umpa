package com.umpa.core.controller.v1.auth.request

import com.umpa.core.domain.user.UserCredential
import jakarta.validation.constraints.Pattern

data class SignUpRequest(
    @field:Pattern(regexp = "^[\\w.-]+@[a-zA-Z_-]+?\\.[a-zA-Z]{2,3}\$", message = "이메일 형식이 올바르지 않습니다.")
    val email: String,
    @field:Pattern(
        regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{6,14}$",
        message = "비밀번호 형식이 올바르지 않습니다. 6~14자 영문 대소문자, 숫자, 특수문자의 조합으로 입력해주세요."
    )
    val password: String
) {
    fun toDomain(): UserCredential {
        return UserCredential(
            email = email,
            password = password
        )
    }
}
