package com.example.weatherapp.domain.repository

import com.example.weatherapp.utils.Either
import kotlinx.coroutines.flow.Flow

interface ApiRepository {
    suspend fun translateText(
        apiKey: String,
        text: String,
        targetLang: String
    ): Flow<Either<Throwable, String>>
}