package com.umpa.song

import org.springframework.data.jpa.repository.JpaRepository

interface SongRepository : JpaRepository<SongEntity, Long>
