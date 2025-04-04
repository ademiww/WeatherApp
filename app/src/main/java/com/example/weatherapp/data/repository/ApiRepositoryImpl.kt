package com.example.weatherapp.data.repository

import com.example.weatherapp.data.bases.BaseRepository
import com.example.weatherapp.data.datasource.ApiService
import com.example.weatherapp.domain.repository.ApiRepository
import com.example.weatherapp.utils.Either
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOn


class ApiRepositoryImpl(
    private val apiService: ApiService,
    private val ioDispatcher: CoroutineDispatcher
) : ApiRepository, BaseRepository() {
    override suspend fun translateText(
        apiKey: String,
        text: String,
        targetLang: String
    ): Flow<Either<Throwable, String>> = makeRequest(
        request = { apiService.translateText(apiKey, text, targetLang) },
        onSuccess = { it.translations?.get(0)?.text ?: "" }
    ).flowOn(ioDispatcher)
}