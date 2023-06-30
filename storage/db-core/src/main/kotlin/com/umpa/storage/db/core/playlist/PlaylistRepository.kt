package com.umpa.storage.db.core.playlist

import org.springframework.data.jpa.repository.JpaRepository

interface PlaylistRepository : JpaRepository<PlaylistEntity, Long> {
    fun findAllByUserIdAndIsDeletedIsFalse(userId: Long): List<PlaylistEntity>
}
