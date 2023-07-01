package com.umpa.core.domain.user

import com.umpa.core.support.exceptions.CoreApiException
import com.umpa.core.support.exceptions.ErrorType
import com.umpa.storage.db.core.user.UserEntity
import com.umpa.storage.db.core.user.UserRepository
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Component

@Component
class UserReader(
    private val userRepository: UserRepository
) {
    fun readByEmail(email: String): UserEntity {
        return userRepository.findOneByEmail(email)
            ?: throw CoreApiException(ErrorType.NOT_FOUND_USER_EMAIL)
    }

    fun readByIdIn(userIds: List<Long>): List<User> {
        return userRepository.findAllByIdIn(userIds)
            .map { User.fromEntity(it) }
    }

    fun readById(userId: Long): User {
        return userRepository.findByIdOrNull(userId)
            ?.let { User.fromEntity(it) }
            ?: throw CoreApiException(ErrorType.NOT_FOUND_USER)
    }
}
