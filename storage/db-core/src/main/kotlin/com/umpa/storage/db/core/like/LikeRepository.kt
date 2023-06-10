package com.umpa.storage.db.core.like

import org.springframework.data.jpa.repository.JpaRepository

interface LikeRepository : JpaRepository<LikeEntity, Long> {
    fun readById(id: Long): LikeEntity?

    fun findByUserIdAndContentId(userId: Long, contentId: Long): LikeEntity?
}
