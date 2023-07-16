package com.umpa.storage.db.core.feed

import com.umpa.storage.db.core.BaseEntity
import com.umpa.commons.enums.ContentType
import jakarta.persistence.*

@Entity
@Table(name = "feed")
class FeedEntity(
    @Column(name = "ref_user_id")
    val userId: Long,

    @Column(name = "ref_content_id")
    val contentId: Long,

    @Column(name = "content_type")
    @Enumerated(value = EnumType.STRING)
    val contentType: ContentType,

    @Column(name = "is_deleted")
    val isDeleted: Boolean = false
) : BaseEntity()
