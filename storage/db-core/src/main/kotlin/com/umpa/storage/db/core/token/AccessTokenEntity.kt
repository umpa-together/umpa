package com.umpa.storage.db.core.token

import com.umpa.storage.db.core.BaseEntity
import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.Table
import java.time.LocalDateTime

@Entity
@Table(name = "access_token")
class AccessTokenEntity(
    @Column(name = "ref_user_id")
    val userId: Long,

    @Column(name = "access_token")
    val accessToken: String,

    @Column(name = "refresh_token")
    val refreshToken: String,

    @Column(name = "expired_at")
    val expiredAt: LocalDateTime,

    @Column(name = "active")
    val active: Boolean = true
) : BaseEntity()
