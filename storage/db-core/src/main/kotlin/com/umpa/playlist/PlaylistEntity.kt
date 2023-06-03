package com.umpa.playlist

import com.umpa.BaseEntity
import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.Table
import java.time.LocalDateTime

@Entity
@Table(name = "playlist")
class PlaylistEntity(
    @Column(name = "ref_user_id")
    val userId: Long,

    @Column(name = "title")
    val title: String,

    @Column(name = "content")
    val content: String,

    @Column(name = "image_url")
    var imageUrl: String? = null,

    @Column(name = "youtube_url")
    val youtubeUrl: String? = null,

    @Column(name = "accessed_at")
    val accessedAt: LocalDateTime = LocalDateTime.now(),

    @Column(name = "view_count")
    val viewCount: Long = 0L,

    @Column(name = "is_deleted")
    val isDeleted: Boolean = false
) : BaseEntity() {
    fun uploadImage(url: String) {
        this.imageUrl = url
    }
}
