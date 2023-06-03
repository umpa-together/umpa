package com.umpa.user

import com.umpa.BaseEntity
import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.Table
import java.time.LocalDateTime

@Entity
@Table(name = "user")
class UserEntity(
    @Column(name = "email")
    val email: String,

    @Column(name = "password")
    val password: String,

    @Column(name = "active")
    val active: Boolean = true,

    @Column(name = "nick_name")
    val nickName: String? = null,

    @Column(name = "real_name")
    val realName: String? = null,

    @Column(name = "introduction")
    val introduction: String? = null,

    @Column(name = "profile_image")
    val profileImage: String? = null,

    @Column(name = "background_image")
    val backgroundImage: String? = null,

    @Column(name = "accessed_at")
    val accessedAt: LocalDateTime? = null
) : BaseEntity()
