package com.vitor.reactivebasicapi.client.impl

import com.vitor.reactivebasicapi.client.SponsorsClient
import com.vitor.reactivebasicapi.dto.SponsorDTO
import org.slf4j.Logger
import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Component
import org.springframework.web.reactive.function.client.WebClient
import java.net.URI

@Component
class SponsorsClientImpl(
    private val webClient: WebClient,
    @Value("\${url.sponsors.api}")
    private val sponsorsURI: String,
    private val logger: Logger
) : SponsorsClient {

    override fun get(name: String) = webClient.get()
        .uri(URI.create(buildPath(name)))
        .retrieve()
        .bodyToMono(SponsorDTO::class.java)
        .doOnSuccess { logger.info("Successfully requested sponsor {}", it) }
        .doOnError { logger.error("Failed to get sponsors data", it) }

    fun buildPath(name: String) = sponsorsURI.plus(name.replace(" ", "+"))
    // fun buildPath(name: String) = sponsorsURI
}
