package com.umpa.storage.db.core.hashtag

import org.springframework.data.jpa.repository.JpaRepository

interface HashtagRepository : JpaRepository<HashtagEntity, Long> {
    fun findAllByContentIdAndIsDeletedIsFalse(contentId: Long): List<HashtagEntity>
}
