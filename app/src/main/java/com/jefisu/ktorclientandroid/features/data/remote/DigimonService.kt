package com.jefisu.ktorclientandroid.features.data.remote

import com.jefisu.ktorclientandroid.features.data.dto.DigimonResponse

interface DigimonService {

    suspend fun getDigimons() : List<DigimonResponse>
}