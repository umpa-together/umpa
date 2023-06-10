package com.umpa.storage.db.core.comment

import com.umpa.commons.enums.ContentType
import com.umpa.storage.db.core.BaseEntity
import jakarta.persistence.*

@Entity
@Table(name = "comment")
class CommentEntity(
    @Column(name = "ref_content_id")
    val contentId: Long,

    @Column(name = "ref_user_id")
    val userId: Long,

    @Column(name = "comment")
    val comment: String,

    @Column(name = "ref_parent_comment_id")
    val parentCommentId: Long? = null,

    @Column(name = "content_type")
    @Enumerated(value = EnumType.STRING)
    val contentType: ContentType,

    @Column(name = "is_deleted")
    var isDeleted: Boolean = false
) : BaseEntity()
