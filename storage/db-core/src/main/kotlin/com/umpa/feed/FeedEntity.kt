package com.umpa.feed

import com.umpa.BaseEntity
import com.umpa.ContentType
import jakarta.persistence.*

@Entity
@Table(name = "feed")
class FeedEntity(
    @Column(name = "ref_user_id")
    val uploadUserId: Long,

    @Column(name = "ref_content_id")
    val contentId: Long,

    @Column(name = "content_type")
    @Enumerated(value = EnumType.STRING)
    val contentType: ContentType,

    @Column(name = "is_deleted")
    val isDeleted: Boolean = false
) : BaseEntity()
