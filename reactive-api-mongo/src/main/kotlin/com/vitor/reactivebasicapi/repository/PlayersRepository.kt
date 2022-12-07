package com.vitor.reactivebasicapi.repository

import com.vitor.reactivebasicapi.model.Player
import reactor.core.publisher.Mono

interface PlayersRepository {
    fun save(player: Player): Mono<Player>
}
