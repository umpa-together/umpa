package com.umpa.storage.db.core.daily

import com.umpa.storage.db.core.BaseEntity
import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.Table
import java.time.LocalDateTime

@Entity
@Table(name = "daily")
class DailyEntity(
    @Column(name = "ref_user_id")
    val userId: Long,

    @Column(name = "content")
    var content: String,

    @Column(name = "image_urls")
    var imageUrls: List<String>? = null,

    @Column(name = "accessed_at")
    val accessedAt: LocalDateTime = LocalDateTime.now(),

    @Column(name = "view_count")
    var viewCount: Long = 0L,

    @Column(name = "is_deleted")
    var isDeleted: Boolean = false
) : BaseEntity() {
    fun increaseViewCount() {
        this.viewCount += 1
    }

    fun editDaily(content: String) {
        this.content = content
    }

    fun delete() {
        this.isDeleted = true
    }
}
