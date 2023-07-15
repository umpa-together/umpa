package com.umpa.core.controller.v1.user.response

import com.umpa.core.domain.user.UserProfileDetail

data class UserProfileDetailResponse(
    val id: Long,
    val nickName: String,
    val realName: String?,
    val introduction: String?,
    val profileImage: String,
    val backgroundImage: String
) {
    constructor(detail: UserProfileDetail) : this(
        id = detail.id,
        nickName = detail.nickName,
        realName = detail.realName,
        introduction = detail.introduction,
        profileImage = detail.profileImage,
        backgroundImage = detail.backgroundImage
    )
}
