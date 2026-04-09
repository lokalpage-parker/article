package com.example.article.configuration

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import java.time.Clock

@Configuration
class ServerConfiguration {

    @Bean
    fun clock(): Clock {
        return Clock.systemUTC()
    }
}
