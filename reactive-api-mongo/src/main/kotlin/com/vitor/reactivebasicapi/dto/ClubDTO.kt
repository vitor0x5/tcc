package com.vitor.reactivebasicapi.dto

import com.fasterxml.jackson.databind.PropertyNamingStrategies
import com.fasterxml.jackson.databind.annotation.JsonNaming

@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy::class)
data class ClubDTO(
    val name: String,
    val country: String,
    val number: String
)
