package com.umpa.hashtag

import org.springframework.data.jpa.repository.JpaRepository

interface HashtagRepository : JpaRepository<HashtagEntity, Long>
