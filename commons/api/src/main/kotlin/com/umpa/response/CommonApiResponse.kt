package com.umpa.response

data class CommonApiResponse<T> (
    val result: ResultType,
    val data: T? = null,
    val error: String? = null
) {
    companion object {
        fun success() = CommonApiResponse(ResultType.SUCCESS, null, null)

        fun <T> success(data: T) = CommonApiResponse(ResultType.SUCCESS, data, null)
    }
}
