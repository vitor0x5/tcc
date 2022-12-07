package com.vitor.reactivebasicapi.router

import com.vitor.reactivebasicapi.handler.CreatePlayerHandler
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.web.reactive.function.server.router

@Configuration
class PlayerRouter(
    val createPlayerHandler: CreatePlayerHandler
) {
    @Bean
    fun playerRoutes() = router {
        POST("/player", createPlayerHandler::execute)
    }
}
