package com.umpa.storage.db.core.hashtag

import com.umpa.storage.db.core.BaseEntity
import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.Table

@Entity
@Table(name = "hashtag")
class HashtagEntity(
    @Column(name = "hashtag")
    val hashtag: String,

    @Column(name = "ref_content_id")
    val contentId: Long,

    @Column(name = "is_deleted")
    var isDeleted: Boolean = false
) : BaseEntity() {
    fun delete() {
        this.isDeleted = true
    }
}
