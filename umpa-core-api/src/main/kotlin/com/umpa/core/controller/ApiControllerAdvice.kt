package com.umpa.core.controller

import org.slf4j.LoggerFactory
import org.springframework.web.bind.annotation.RestControllerAdvice

@RestControllerAdvice
class ApiControllerAdvice {
    private val logger = LoggerFactory.getLogger(javaClass)

//    @ExceptionHandler(MethodArgumentNotValidException::class)
//    fun handleMethodArgumentNotValidException(e: MethodArgumentNotValidException): CommonApiResponse<> {
//        logger.info("${e.message}", e)
//        return CommonApiResponse
//    }
}
