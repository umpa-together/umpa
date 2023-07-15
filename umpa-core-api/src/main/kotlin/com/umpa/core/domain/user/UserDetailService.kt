package com.umpa.core.domain.user

import com.umpa.commons.enums.ContentType
import com.umpa.core.domain.content.UserContentReader
import com.umpa.core.domain.follow.FollowReader
import com.umpa.core.domain.song.SongReader
import org.springframework.stereotype.Service

@Service
class UserDetailService(
    private val userReader: UserReader,
    private val songReader: SongReader,
    private val followReader: FollowReader,
    private val userContentReader: UserContentReader
) {
    fun get(userId: Long): UserDetail {
        val profileDetail = userReader.readById(userId).profileDetail()
        val songs = songReader.readByUserIdAndContentType(userId, ContentType.USER_REPRESENT)
        val followShipCount = followReader.readFollowShipCountByUserId(userId)
        val contentDetail = userContentReader.readByUserId(userId)
        return UserDetail(
            profile = profileDetail,
            representSongs = songs,
            followShipCount = followShipCount,
            content = contentDetail
        )
    }
}
