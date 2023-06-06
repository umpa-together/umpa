package com.umpa.core.support.utils

object PatternUtils {
    private val patternSpc = Regex("[~!@#\$%^&*()_+|<>?:{}]")
    private val patternNum = Regex("[0-9]")
    private val patternEng = Regex("[a-zA-Z]")
    private val patternKor = Regex("[ㄱ-ㅎ|ㅏ-ㅣ|가-힣]")

    fun isKorAndEngAndNumAndNotSpc(text: String): Boolean {
        return (
            !patternSpc.containsMatchIn(text) &&
                (
                    patternEng.containsMatchIn(text) ||
                        patternKor.containsMatchIn(text) ||
                        patternNum.containsMatchIn(text)
                    )
            )
    }
}
