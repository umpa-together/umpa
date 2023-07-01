package com.umpa.core.fixtures.domains.hashtag

import com.umpa.core.domain.hashtag.HashtagCreation

class HashtagCreationBuilder(
    val hashtag: String = "",
    val contentId: Long = 0L
) {
    fun build(): HashtagCreation {
        return HashtagCreation(
            hashtag = hashtag,
            contentId = contentId
        )
    }
}
