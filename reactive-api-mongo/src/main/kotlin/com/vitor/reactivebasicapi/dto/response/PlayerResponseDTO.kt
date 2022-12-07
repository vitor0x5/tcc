package com.vitor.reactivebasicapi.dto.response

import com.fasterxml.jackson.databind.PropertyNamingStrategies
import com.fasterxml.jackson.databind.annotation.JsonNaming
import com.vitor.reactivebasicapi.dto.ClubDTO
import com.vitor.reactivebasicapi.dto.NationalTeamDTO
import com.vitor.reactivebasicapi.dto.SponsorDTO
import java.util.*

@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy::class)
data class PlayerResponseDTO(
    val id: String,
    val name: String,
    val position: String,
    val specialities: List<String>,
    val birth_date: Date,
    val height: Long,
    val weight: Int,
    val goals: Int,
    val assists: Int,
    val clubs: List<ClubDTO>,
    val nationalTeam: NationalTeamDTO,
    val sponsor: SponsorDTO
)
