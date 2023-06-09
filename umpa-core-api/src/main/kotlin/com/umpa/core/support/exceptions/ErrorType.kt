package com.umpa.core.support.exceptions

import org.springframework.http.HttpStatus

enum class ErrorType(val statusCode: HttpStatus, val errorCode: ErrorCode, val message: String) {
    ALREADY_EXISTS_EMAIL(HttpStatus.BAD_REQUEST, ErrorCode.E4000, "이미 존재하는 이메일입니다. 다른 이메일을 통해 회원가입을 진행해주세요."),
    NOT_SUPPORTED_SONGS_COUNT(HttpStatus.BAD_REQUEST, ErrorCode.E4001, "플레이리스트 등록할 곡은 최소 3개 최대 8개입니다."),
    NOT_SUPPORTED_SPC_PATTERN(HttpStatus.BAD_REQUEST, ErrorCode.E4002, "특수문자를 포함할 수 없습니다. 한글, 영문, 숫자로 입력해주세요"),

    BAD_CREDENTIALS(HttpStatus.FORBIDDEN, ErrorCode.E4030, "입력하신 비밀번호와 일치하지 않습니다."),
    FORBIDDEN_CONTENT_ID(HttpStatus.FORBIDDEN, ErrorCode.E4031, "해당 컨텐츠와 일치하지 않습니다."),
    FORBIDDEN_USER_ID(HttpStatus.FORBIDDEN, ErrorCode.E4032, "해당 유저와 일치하지 않습니다."),
    FORBIDDEN_UNLIKE(HttpStatus.FORBIDDEN, ErrorCode.E4033, "좋아요를 취소할 수 없습니다."),

    NOT_FOUND_USER_EMAIL(HttpStatus.NOT_FOUND, ErrorCode.E4040, "해당 이메일과 일치하는 유저를 찾을 수 없습니다."),
    NOT_FOUND_COMMENT(HttpStatus.NOT_FOUND, ErrorCode.E4041, "해당 댓글을 찾을 수 없습니다."),
    NOT_FOUND_LIKES(HttpStatus.NOT_FOUND, ErrorCode.E4042, "해당 좋아요를 찾을 수 없습니다.")
}
