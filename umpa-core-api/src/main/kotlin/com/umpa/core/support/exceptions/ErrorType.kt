package com.umpa.core.support.exceptions

import org.springframework.http.HttpStatus

enum class ErrorType(val statusCode: HttpStatus, val errorCode: ErrorCode, val message: String) {

    ALREADY_EXISTS_EMAIL(HttpStatus.BAD_REQUEST, ErrorCode.E4000, "이미 존재하는 이메일입니다. 다른 이메일을 통해 회원가입을 진행해주세요.")
}
