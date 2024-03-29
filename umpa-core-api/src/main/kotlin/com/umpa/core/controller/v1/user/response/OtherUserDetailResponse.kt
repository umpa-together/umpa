package com.umpa.core.controller.v1.user.response

import com.umpa.core.domain.song.spotify.Track
import com.umpa.core.domain.user.UserDetail

data class OtherUserDetailResponse(
    val profile: UserProfileDetailResponse,
    val followShipCount: UserFollowShipCountResponse,
    val representSongs: List<Track>,
    val content: UserContentDetailResponse,
    val canFollow: Boolean
) {
    constructor(detail: UserDetail, userId: Long) : this(
        profile = UserProfileDetailResponse(detail.profile),
        followShipCount = UserFollowShipCountResponse(detail.followingAndFollower),
        representSongs = detail.representSongs,
        content = UserContentDetailResponse(detail.content),
        canFollow = detail.followingAndFollower.followerUserIds.contains(userId)
    )
}
