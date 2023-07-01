package com.umpa.core.domain.song.spotify

import com.umpa.client.spotify.response.TrackDetailResponse
import com.umpa.storage.db.core.song.SongEntity

data class Track(
    val id: String,
    val name: String,
    val artistNames: List<String>,
    val albumImage: AlbumImage,
    val isExplicit: Boolean,
    val previewUrl: String?
) {
    companion object {
        fun fromTrackDetailResponse(response: TrackDetailResponse): Track {
            return Track(
                id = response.id,
                name = response.name,
                artistNames = response.artists.map { it.name },
                albumImage = AlbumImage.fromImageResponse(response.album.images[0]),
                isExplicit = response.explicit,
                previewUrl = response.previewUrl
            )
        }

        fun fromEntity(entity: SongEntity): Track {
            return Track(
                id = entity.spotifyTrackId,
                name = entity.name,
                artistNames = entity.artistNames.map { it },
                albumImage = AlbumImage(entity.albumImage),
                isExplicit = entity.isExplicit,
                previewUrl = entity.previewUrl
            )
        }
    }
}
