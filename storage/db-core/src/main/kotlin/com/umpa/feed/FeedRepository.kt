package com.umpa.feed

import org.springframework.data.jpa.repository.JpaRepository

interface FeedRepository : JpaRepository<FeedEntity, Long>
