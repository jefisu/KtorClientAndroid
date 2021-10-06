package com.jefisu.ktorclientandroid.features.data.dto

import kotlinx.serialization.Serializable

@Serializable
data class DigimonResponse(
    val name: String,
    val img: String,
    val level: String
)
