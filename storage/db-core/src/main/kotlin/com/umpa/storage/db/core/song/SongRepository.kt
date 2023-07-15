package com.umpa.storage.db.core.song

import com.umpa.commons.enums.ContentType
import org.springframework.data.jpa.repository.JpaRepository

interface SongRepository : JpaRepository<SongEntity, Long> {
    fun findAllByContentIdAndIsDeletedIsFalse(contentId: Long): List<SongEntity>

    fun findAllByContentId(contentId: Long): List<SongEntity>

    fun findAllByUserIdAndIsDeletedIsFalse(userId: Long): List<SongEntity>

    fun findAllByContentIdInAndContentTypeAndIsDeletedIsFalse(contentIds: List<Long>, contentType: ContentType): List<SongEntity>
}
