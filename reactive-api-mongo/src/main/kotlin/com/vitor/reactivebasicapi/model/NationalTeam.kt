package com.vitor.reactivebasicapi.model

import java.util.*

data class NationalTeam(
    val country: String,
    val firstAppearance: Date,
    val number: String,
    val goals: Int
)
