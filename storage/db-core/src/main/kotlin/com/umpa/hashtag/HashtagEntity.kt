package com.umpa.hashtag

import com.umpa.BaseEntity
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
    val isDeleted: Boolean = false
) : BaseEntity()
