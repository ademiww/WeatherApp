package com.example.weatherapp.data.bases

import com.example.weatherapp.data.models.Translation
import com.example.weatherapp.utils.Either
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import retrofit2.Response

abstract class BaseRepository {

    protected fun <T, R> makeRequest(
        request: suspend () -> Response<T>,
        onSuccess: (T) -> R,
    ): Flow<Either<Throwable, R>> = flow{
        try {
            val response = request()
            if (response.isSuccessful && response.body() != null) {
                emit(Either.Success(onSuccess(response.body()!!)))
            } else {
                emit(Either.Error(Exception("Ошибка сети")))
            }
        } catch (e: Exception) {
            emit(Either.Error(e))
        }
    }
}