package com.umpa.storage.db.core.daily

import org.springframework.data.jpa.repository.JpaRepository

interface DailyRepository : JpaRepository<DailyEntity, Long>
