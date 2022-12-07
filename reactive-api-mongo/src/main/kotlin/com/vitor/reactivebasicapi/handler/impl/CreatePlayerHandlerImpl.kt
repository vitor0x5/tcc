package com.vitor.reactivebasicapi.handler.impl

import com.vitor.reactivebasicapi.client.SponsorsClient
import com.vitor.reactivebasicapi.dto.request.PlayerRequestDTO
import com.vitor.reactivebasicapi.dto.response.PlayerResponseDTO
import com.vitor.reactivebasicapi.handler.CreatePlayerHandler
import com.vitor.reactivebasicapi.model.Player
import com.vitor.reactivebasicapi.repository.PlayersRepository
import com.vitor.reactivebasicapi.utils.toEntity
import com.vitor.reactivebasicapi.utils.toResponseDTO
import org.slf4j.Logger
import org.springframework.http.MediaType
import org.springframework.stereotype.Component
import org.springframework.web.reactive.function.server.ServerRequest
import org.springframework.web.reactive.function.server.ServerResponse
import reactor.core.publisher.Mono
import reactor.kotlin.core.publisher.toMono
import java.net.URI

@Component
class CreatePlayerHandlerImpl(
    private val playersRepository: PlayersRepository,
    private val sponsorsClient: SponsorsClient,
    private val logger: Logger
) : CreatePlayerHandler {

    override fun execute(serverRequest: ServerRequest): Mono<ServerResponse> {
        return serverRequest.bodyToMono(PlayerRequestDTO::class.java)
            .doOnSubscribe { logger.info("Received create player request") }
            .flatMap { buildEntityWithSponsor(it) }
            .flatMap { playersRepository.save(it) }
            .flatMap { buildServerResponse(it) }
            .doOnSuccess { logger.info("Player saved on database successfully!") }
            .doOnError { logger.error("Failed to save player on database", it) }
    }

    private fun buildEntityWithSponsor(playerRequestDTO: PlayerRequestDTO): Mono<Player> {
        return sponsorsClient.get(playerRequestDTO.name)
            .flatMap { playerRequestDTO.toEntity(it).toMono() }
    }

    private fun buildServerResponse(player: Player) = ServerResponse
        .created(URI.create("/player/${player.id}"))
        .contentType(MediaType.APPLICATION_JSON)
        .body(player.toResponseDTO(), PlayerResponseDTO::class.java)
}
