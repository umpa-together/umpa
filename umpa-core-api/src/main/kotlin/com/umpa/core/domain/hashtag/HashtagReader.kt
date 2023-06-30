package com.umpa.core.domain.hashtag

import com.umpa.storage.db.core.hashtag.HashtagRepository
import org.springframework.stereotype.Component

@Component
class HashtagReader(
    private val hashtagRepository: HashtagRepository
) {
    fun readByContentId(contentId: Long): List<String> {
        return hashtagRepository.findAllByContentIdAndIsDeletedIsFalse(contentId).map { it.hashtag }
    }
}
