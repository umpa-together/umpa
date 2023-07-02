package com.umpa.storage.db.core.song

import com.umpa.storage.db.core.BaseEntity
import com.umpa.commons.enums.ContentType
import jakarta.persistence.*

@Entity
@Table(name = "song")
class SongEntity(
    @Column(name = "ref_user_id")
    val uploadUserId: Long,

    @Column(name = "ref_content_id")
    val contentId: Long,

    @Column(name = "spotify_track_id")
    val spotifyTrackId: String,

    @Column(name = "name")
    val name: String,

    @Column(name = "artist_names")
    val artistNames: List<String>,

    @Column(name = "album_image")
    val albumImage: String,

    @Column(name = "is_explicit")
    val isExplicit: Boolean,

    @Column(name = "preview_url")
    val previewUrl: String? = null,

    @Column(name = "content_type")
    @Enumerated(value = EnumType.STRING)
    val contentType: ContentType,

    @Column(name = "is_deleted")
    var isDeleted: Boolean = false
) : BaseEntity() {
    fun delete() {
        this.isDeleted = true
    }
}
