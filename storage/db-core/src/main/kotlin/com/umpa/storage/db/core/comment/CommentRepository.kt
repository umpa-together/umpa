package com.umpa.storage.db.core.comment

import org.springframework.data.jpa.repository.JpaRepository

interface CommentRepository : JpaRepository<CommentEntity, Long> {
    fun readById(id: Long): CommentEntity?
}
