package com.umpa.core.domain.song

import com.umpa.storage.db.core.song.SongEntity
import com.umpa.storage.db.core.song.SongRepository
import jakarta.transaction.Transactional
import org.springframework.stereotype.Component

@Component
class SongUpdater(
    private val songRepository: SongRepository,
    private val songCreator: SongCreator
) {
    @Transactional
    fun edit(contentId: Long, songCreations: List<SongCreation>) {
        val songsInContent = songRepository.findAllByContentIdAndIsDeletedIsFalse(contentId)
        deleteContentSongsNotInEditSongs(songsInContent, songCreations)
        addEditSongsNotInContentSongs(songsInContent, songCreations)
    }

    private fun deleteContentSongsNotInEditSongs(songsInContent: List<SongEntity>, songCreations: List<SongCreation>) {
        val editSongTrackIds = songCreations.map { it.id }
        songsInContent.filter { !editSongTrackIds.contains(it.spotifyTrackId) }
            .forEach { it.delete() }
    }

    private fun addEditSongsNotInContentSongs(songsInContent: List<SongEntity>, songCreations: List<SongCreation>) {
        val contentSongTrackIds = songsInContent.map { it.spotifyTrackId }
        val addTargetSongs = songCreations.filter { !contentSongTrackIds.contains(it.id) }
        if (addTargetSongs.isNotEmpty()) {
            songCreator.create(addTargetSongs)
        }
    }

    @Transactional
    fun delete(contentId: Long) {
        songRepository.findAllByContentId(contentId)
            .forEach { it.delete() }
    }
}
