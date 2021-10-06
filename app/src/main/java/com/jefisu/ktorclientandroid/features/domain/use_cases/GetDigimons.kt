package com.jefisu.ktorclientandroid.features.domain.use_cases

import com.jefisu.ktorclientandroid.features.data.dto.DigimonResponse
import com.jefisu.ktorclientandroid.features.data.remote.DigimonService

class GetDigimons(
    private val service: DigimonService
) {

    suspend operator fun invoke() : List<DigimonResponse> {
        return service.getDigimons()
    }
}