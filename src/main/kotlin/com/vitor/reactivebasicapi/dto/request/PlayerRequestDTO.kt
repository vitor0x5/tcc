package com.vitor.reactivebasicapi.dto.request

import com.fasterxml.jackson.databind.PropertyNamingStrategies
import com.fasterxml.jackson.databind.annotation.JsonNaming
import com.vitor.reactivebasicapi.dto.ClubDTO
import com.vitor.reactivebasicapi.dto.NationalTeamDTO
import java.util.*

@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy::class)
data class PlayerRequestDTO(
    val name: String,
    val position: String,
    val specialities: List<String>,
    val birth_date: Date,
    val height: Long,
    val weight: Int,
    val goals: Int,
    val assists: Int,
    val clubs: List<ClubDTO>,
    val nationalTeam: NationalTeamDTO
)
