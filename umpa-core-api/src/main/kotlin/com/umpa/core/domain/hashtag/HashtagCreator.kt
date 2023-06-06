package com.umpa.core.domain.hashtag

import com.umpa.storage.db.core.hashtag.HashtagRepository
import org.springframework.stereotype.Component

@Component
class HashtagCreator(
    private val repository: HashtagRepository
) {
    fun create(creations: List<HashtagCreation>) {
        repository.saveAll(creations.map { it.toEntity() })
    }
}
