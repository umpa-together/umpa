package com.umpa.core.domain.hashtag

import com.umpa.storage.db.core.hashtag.HashtagEntity
import com.umpa.storage.db.core.hashtag.HashtagRepository
import jakarta.transaction.Transactional
import org.springframework.stereotype.Component

@Component
class HashtagUpdater(
    private val hashtagRepository: HashtagRepository,
    private val hashtagCreator: HashtagCreator
) {
    @Transactional
    fun edit(contentId: Long, hashtagCreations: List<HashtagCreation>) {
        val hashtagsInContent = hashtagRepository.findAllByContentIdAndIsDeletedIsFalse(contentId)
        deleteContentHashtagsNotInEditHashtags(hashtagsInContent, hashtagCreations)
        addEditHashtagsNotInContentHashtags(hashtagsInContent, hashtagCreations)
    }

    private fun deleteContentHashtagsNotInEditHashtags(hashtagsInContent: List<HashtagEntity>, hashtagCreations: List<HashtagCreation>) {
        val editHashtags = hashtagCreations.map { it.hashtag }
        hashtagsInContent.filter { !editHashtags.contains(it.hashtag) }
            .forEach { it.delete() }
    }

    private fun addEditHashtagsNotInContentHashtags(hashtagsInContent: List<HashtagEntity>, hashtagCreations: List<HashtagCreation>) {
        val contentHashtags = hashtagsInContent.map { it.hashtag }
        val addTargetHashtags = hashtagCreations.filter { !contentHashtags.contains(it.hashtag) }
        if (addTargetHashtags.isNotEmpty()) {
            hashtagCreator.create(addTargetHashtags)
        }
    }

    @Transactional
    fun delete(contentId: Long) {
        hashtagRepository.findAllByContentId(contentId)
            .forEach { it.delete() }
    }
}
