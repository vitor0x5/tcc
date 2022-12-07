package com.vitor.reactivebasicapi.client

import com.vitor.reactivebasicapi.dto.SponsorDTO
import reactor.core.publisher.Mono

interface SponsorsClient {
    fun get(name: String): Mono<SponsorDTO>
}
