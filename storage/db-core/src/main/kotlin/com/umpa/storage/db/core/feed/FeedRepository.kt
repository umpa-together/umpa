package com.umpa.storage.db.core.feed

import org.springframework.data.jpa.repository.JpaRepository

interface FeedRepository : JpaRepository<FeedEntity, Long>
