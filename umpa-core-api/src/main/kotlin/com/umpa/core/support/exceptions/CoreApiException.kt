package com.umpa.core.support.exceptions

data class CoreApiException(
    val errorType: ErrorType
) : RuntimeException(errorType.message)
