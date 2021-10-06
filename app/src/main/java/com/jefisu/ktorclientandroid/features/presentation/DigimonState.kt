package com.jefisu.ktorclientandroid.features.presentation

import com.jefisu.ktorclientandroid.features.data.dto.DigimonResponse

data class DigimonState(
    val digimons: List<DigimonResponse> = emptyList(),
    val isLoading: Boolean = true
)