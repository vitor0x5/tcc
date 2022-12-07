package com.vitor.reactivebasicapi.dto

import com.fasterxml.jackson.databind.PropertyNamingStrategies
import com.fasterxml.jackson.databind.annotation.JsonNaming
import java.util.*

@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy::class)
data class NationalTeamDTO(
    val country: String,
    val firstAppearance: Date,
    val number: String,
    val goals: Int
)
