package com.umpa.client.spotify

import feign.Logger
import org.springframework.cloud.openfeign.EnableFeignClients
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
@EnableFeignClients
internal class SpotifyConfig {
    @Bean
    internal fun feignLoggerLevel(): Logger.Level {
        return Logger.Level.FULL
    }
}
