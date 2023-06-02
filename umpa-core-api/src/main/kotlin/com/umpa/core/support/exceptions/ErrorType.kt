package com.umpa.core.support.exceptions

import org.springframework.http.HttpStatus

enum class ErrorType(val statusCode: HttpStatus, val errorCode: ErrorCode, val message: String) {

    ALREADY_EXISTS_EMAIL(HttpStatus.BAD_REQUEST, ErrorCode.E4000, "이미 존재하는 이메일입니다. 다른 이메일을 통해 회원가입을 진행해주세요."),

    BAD_CREDENTIALS(HttpStatus.FORBIDDEN, ErrorCode.E4030, "입력하신 비밀번호와 일치하지 않습니다."),

    NOT_FOUND_USER_EMAIL(HttpStatus.NOT_FOUND, ErrorCode.E4040, "해당 이메일과 일치하는 유저를 찾을 수 없습니다.")
}
