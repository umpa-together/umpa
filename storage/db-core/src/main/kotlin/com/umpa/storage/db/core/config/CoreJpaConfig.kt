package com.umpa.storage.db.core.config

import org.springframework.boot.autoconfigure.domain.EntityScan
import org.springframework.context.annotation.Configuration
import org.springframework.data.jpa.repository.config.EnableJpaAuditing
import org.springframework.data.jpa.repository.config.EnableJpaRepositories

@EnableJpaAuditing
@EntityScan("com.umpa")
@EnableJpaRepositories("com.umpa")
@Configuration
internal class CoreJpaConfig
