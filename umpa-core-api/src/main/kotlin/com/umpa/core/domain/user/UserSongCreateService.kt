package com.umpa.core.domain.user

import com.umpa.core.domain.song.SongCreator
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Service

@Service
class UserSongCreateService(
    private val songCreator: SongCreator
) {
    private val logger = LoggerFactory.getLogger(javaClass)

    fun create(creation: UserSongCreation) {
        logger.info("enroll songs ${creation.userId} | ${creation.songs}")
        songCreator.create(creation.toSongCreations())
    }
}
