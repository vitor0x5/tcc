package com.vitor.reactivebasicapi.model

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document
import java.util.*

@Document(collection = "player")
data class Player(
    @Id
    val id: String,

    val name: String,
    val position: String,
    val specialities: List<String>,
    val birth_date: Date,
    val height: Long,
    val weight: Int,
    val goals: Int,
    val assists: Int,
    val clubs: List<Club>,
    val nationalTeam: NationalTeam,
    val sponsor: Sponsor
)
