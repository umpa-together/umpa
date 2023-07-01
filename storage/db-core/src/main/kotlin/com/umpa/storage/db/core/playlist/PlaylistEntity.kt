package com.umpa.storage.db.core.playlist

import com.umpa.storage.db.core.BaseEntity
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
    var title: String,

    @Column(name = "content")
    var content: String,

    @Column(name = "image_url")
    var imageUrl: String? = null,

    @Column(name = "youtube_url")
    val youtubeUrl: String? = null,

    @Column(name = "accessed_at")
    val accessedAt: LocalDateTime = LocalDateTime.now(),

    @Column(name = "view_count")
    var viewCount: Long = 0L,

    @Column(name = "is_deleted")
    var isDeleted: Boolean = false
) : BaseEntity() {
    fun uploadImage(url: String) {
        this.imageUrl = url
    }

    fun increaseViewCount() {
        this.viewCount += 1
    }

    fun editPlaylist(title: String, content: String) {
        this.title = title
        this.content = content
    }

    fun delete() {
        this.isDeleted = true
    }
}
