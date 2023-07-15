package com.umpa.core.domain.user

import com.umpa.core.domain.content.UserContentDetail
import com.umpa.core.domain.follow.FollowShipCount
import com.umpa.core.domain.song.spotify.Track

data class UserDetail(
    val profile: UserProfileDetail,
    val followShipCount: FollowShipCount,
    val representSongs: List<Track>,
    val content: UserContentDetail
)
