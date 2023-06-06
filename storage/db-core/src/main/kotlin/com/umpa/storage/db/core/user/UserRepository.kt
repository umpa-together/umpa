package com.umpa.storage.db.core.user

import org.springframework.data.jpa.repository.JpaRepository

interface UserRepository : JpaRepository<UserEntity, Long> {
    fun existsByEmail(email: String): Boolean

    fun findOneByEmail(email: String): UserEntity?
}
