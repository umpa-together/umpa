package com.umpa.storage.db.core

import jakarta.persistence.*
import org.springframework.data.annotation.CreatedDate
import org.springframework.data.annotation.LastModifiedDate
import org.springframework.data.jpa.domain.support.AuditingEntityListener
import java.time.LocalDateTime

@MappedSuperclass
@EntityListeners(AuditingEntityListener::class)
abstract class BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    val id: Long = 0L

    @Column(name = "created_at", updatable = false)
    @CreatedDate
    var createdAt: LocalDateTime = LocalDateTime.now()
        private set

    @Column(name = "updated_at")
    @LastModifiedDate
    var updatedAt: LocalDateTime = LocalDateTime.now()
        private set
}
