package com.jefisu.ktorclientandroid.di

import com.jefisu.ktorclientandroid.features.data.remote.DigimonService
import com.jefisu.ktorclientandroid.features.data.remote.DigimonServiceImp
import com.jefisu.ktorclientandroid.features.domain.use_cases.GetDigimons
import com.jefisu.ktorclientandroid.features.domain.use_cases.DigimonUseCases
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import io.ktor.client.*
import io.ktor.client.engine.android.*
import io.ktor.client.features.json.*
import io.ktor.client.features.json.serializer.*
import io.ktor.client.features.logging.*
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideDigimonService() : DigimonService {
        return DigimonServiceImp(
            client = HttpClient(Android) {
                install(Logging) {
                    level = LogLevel.ALL
                }
                install(JsonFeature) {
                    serializer = KotlinxSerializer()
                }
            }
        )
    }

    @Provides
    @Singleton
    fun provideDigimonUseCases(service: DigimonService) : DigimonUseCases {
        return DigimonUseCases(
            getDigimons = GetDigimons(service)
        )
    }
}