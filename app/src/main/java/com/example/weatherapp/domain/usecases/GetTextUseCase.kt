package com.example.weatherapp.domain.usecases

import com.example.weatherapp.domain.repository.ApiRepository
import com.example.weatherapp.utils.Either
import kotlinx.coroutines.flow.Flow

class GetTextUseCase(
    private val apiRepository: ApiRepository
) {
    suspend fun execute(
        apiKey: String,
        text: String,
        targetLang: String
    ): Flow<Either<Throwable, String>> {
        return apiRepository.translateText(apiKey, text, targetLang)
    }
}
