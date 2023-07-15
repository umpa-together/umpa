package com.umpa.core.controller.v1.user.response

import com.umpa.core.domain.song.spotify.Track
import com.umpa.core.domain.user.UserDetail

data class UserDetailResponse(
    val profile: UserProfileDetailResponse,
    val followShipCount: UserFollowShipCountResponse,
    val representSongs: List<Track>,
    val content: UserContentDetailResponse
) {
    constructor(detail: UserDetail) : this(
        profile = UserProfileDetailResponse(detail.profile),
        followShipCount = UserFollowShipCountResponse(detail.followShipCount),
        representSongs = detail.representSongs,
        content = UserContentDetailResponse(detail.content)
    )
}
