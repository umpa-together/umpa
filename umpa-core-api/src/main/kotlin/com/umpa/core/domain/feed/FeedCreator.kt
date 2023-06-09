package com.umpa.core.domain.feed

import com.umpa.storage.db.core.feed.FeedRepository
import org.springframework.stereotype.Component

@Component
class FeedCreator(
    private val repository: FeedRepository
) {
    fun create(creation: FeedCreation) {
        repository.save(creation.toEntity())
    }
}
