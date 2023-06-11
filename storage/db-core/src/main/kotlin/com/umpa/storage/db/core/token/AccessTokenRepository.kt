package com.umpa.storage.db.core.token

import org.springframework.data.jpa.repository.JpaRepository

interface AccessTokenRepository : JpaRepository<AccessTokenEntity, Long>
