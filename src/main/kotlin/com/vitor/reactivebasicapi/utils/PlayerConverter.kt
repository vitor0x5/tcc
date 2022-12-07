package com.vitor.reactivebasicapi.utils
import com.vitor.reactivebasicapi.dto.ClubDTO
import com.vitor.reactivebasicapi.dto.NationalTeamDTO
import com.vitor.reactivebasicapi.dto.SponsorDTO
import com.vitor.reactivebasicapi.dto.request.PlayerRequestDTO
import com.vitor.reactivebasicapi.dto.response.PlayerResponseDTO
import com.vitor.reactivebasicapi.model.Club
import com.vitor.reactivebasicapi.model.NationalTeam
import com.vitor.reactivebasicapi.model.Player
import com.vitor.reactivebasicapi.model.Sponsor
import reactor.core.publisher.Mono
import java.util.*

fun PlayerRequestDTO.toEntity(sponsor: SponsorDTO) = Player(
    id = UUID.randomUUID().toString(),
    name,
    position,
    specialities,
    birth_date,
    height,
    weight,
    goals,
    assists,
    clubs.toEntity(),
    nationalTeam.toEntity(),
    sponsor.toEntity()
)

private fun List<ClubDTO>.toEntity() = this.map { Club(it.name, it.country, it.number) }
private fun NationalTeamDTO.toEntity() = NationalTeam(country, firstAppearance, number, goals)
private fun SponsorDTO.toEntity() = Sponsor(name, country)

fun Player.toResponseDTO() = Mono.just(
    PlayerResponseDTO(
        id,
        name,
        position,
        specialities,
        birth_date,
        height,
        weight,
        goals,
        assists,
        clubs.toDTO(),
        nationalTeam.toDTO(),
        sponsor.toDTO()
    )
)

private fun List<Club>.toDTO() = this.map { ClubDTO(it.name, it.country, it.number) }
private fun NationalTeam.toDTO() = NationalTeamDTO(country, firstAppearance, number, goals)
private fun Sponsor.toDTO() = SponsorDTO(name, country)
