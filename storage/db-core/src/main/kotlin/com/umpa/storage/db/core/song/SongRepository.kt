package com.umpa.storage.db.core.song

import org.springframework.data.jpa.repository.JpaRepository

interface SongRepository : JpaRepository<SongEntity, Long> {
    fun findAllByContentIdAndIsDeletedIsFalse(contentId: Long): List<SongEntity>

    fun findAllByContentId(contentId: Long): List<SongEntity>
}
