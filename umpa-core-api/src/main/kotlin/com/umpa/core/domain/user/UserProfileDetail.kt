package com.umpa.core.domain.user

data class UserProfileDetail(
    val id: Long,
    val nickName: String,
    val realName: String?,
    val introduction: String?,
    val profileImage: String,
    val backgroundImage: String
) {
    companion object {
        fun fromUser(user: User): UserProfileDetail {
            return UserProfileDetail(
                id = user.id,
                nickName = user.nickName!!,
                realName = user.realName,
                introduction = user.introduction,
                profileImage = user.profileImage,
                backgroundImage = user.backgroundImage
            )
        }
    }
}
