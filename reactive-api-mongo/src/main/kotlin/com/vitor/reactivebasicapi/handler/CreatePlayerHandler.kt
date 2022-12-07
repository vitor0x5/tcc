package com.vitor.reactivebasicapi.handler

import org.springframework.web.reactive.function.server.ServerRequest
import org.springframework.web.reactive.function.server.ServerResponse
import reactor.core.publisher.Mono

interface CreatePlayerHandler {
    fun execute(serverRequest: ServerRequest): Mono<ServerResponse>
}
