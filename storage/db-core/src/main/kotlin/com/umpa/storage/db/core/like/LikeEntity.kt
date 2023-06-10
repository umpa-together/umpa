package com.umpa.storage.db.core.like

import com.umpa.commons.enums.LikeType
import com.umpa.storage.db.core.BaseEntity
import jakarta.persistence.*

@Entity
@Table(name = "likes")
class LikeEntity(
    @Column(name = "ref_user_id")
    val userId: Long,

    @Column(name = "ref_content_id")
    val contentId: Long,

    @Column(name = "like_type")
    @Enumerated(value = EnumType.STRING)
    val likeType: LikeType,

    @Column(name = "is_like")
    var isLike: Boolean = true
) : BaseEntity() {
    private fun canLike(): Boolean {
        return isLike
    }

    fun unLike() {
        if (canLike()) {
            this.isLike = false
        }
    }
}
