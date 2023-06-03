package com.umpa.playlist

import org.springframework.data.jpa.repository.JpaRepository

interface PlaylistRepository : JpaRepository<PlaylistEntity, Long>
