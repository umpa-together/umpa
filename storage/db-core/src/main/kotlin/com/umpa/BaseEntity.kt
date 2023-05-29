package com.umpa

import jakarta.persistence.*
import org.springframework.data.annotation.CreatedDate
import org.springframework.data.annotation.LastModifiedDate
import java.time.LocalDateTime

@MappedSuperclass
abstract class BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    val id: Long = 0L

    @Column(name = "created_at", updatable = false)
    @CreatedDate
    val createdAt: LocalDateTime? = null

    @Column(name = "updated_at")
    @LastModifiedDate
    val updatedAt: LocalDateTime? = null
}
