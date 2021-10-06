package com.jefisu.ktorclientandroid.features.data.remote

import com.jefisu.ktorclientandroid.features.data.dto.DigimonResponse
import io.ktor.client.*
import io.ktor.client.features.*
import io.ktor.client.request.*

class DigimonServiceImp(
    private val client: HttpClient
) : DigimonService {

    override suspend fun getDigimons(): List<DigimonResponse> {
       return try {
           client.get {
               url(HttpRoutes.DIGIMON)
           }
       } catch (e: RedirectResponseException) {
           //3xx - responses
           println("Error: ${e.response.status.description}")
           emptyList()
       } catch (e: ClientRequestException) {
           // 4xx - responses
            println("Error: ${e.response.status.description}")
           emptyList()
       }
       catch (e: ServerResponseException) {
           // 5xx - responses
           println("Error: ${e.response.status.description}")
           emptyList()
       }
    }
}