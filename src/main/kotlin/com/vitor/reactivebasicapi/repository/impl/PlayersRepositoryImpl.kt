package com.vitor.reactivebasicapi.repository.impl

import com.vitor.reactivebasicapi.model.Player
import com.vitor.reactivebasicapi.repository.PlayersRepository
import org.springframework.data.mongodb.repository.ReactiveMongoRepository
import org.springframework.stereotype.Repository
import reactor.core.publisher.Mono

@Repository
interface PlayersRepositoryImpl : PlayersRepository, ReactiveMongoRepository<Player, String> {
    override fun save(player: Player): Mono<Player>
}
