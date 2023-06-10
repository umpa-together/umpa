package com.umpa.core.domain.like

import com.umpa.core.support.exceptions.CoreApiException
import com.umpa.core.support.exceptions.ErrorType
import com.umpa.storage.db.core.like.LikeEntity
import com.umpa.storage.db.core.like.LikeRepository
import org.springframework.stereotype.Component

@Component
class LikeReader(
    private val likeRepository: LikeRepository
) {
    fun readById(id: Long): LikeEntity {
        return likeRepository.readById(id)
            ?: throw CoreApiException(ErrorType.NOT_FOUND_LIKES)
    }
}
