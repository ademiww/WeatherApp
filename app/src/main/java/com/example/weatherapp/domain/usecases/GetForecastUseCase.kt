package com.example.weatherapp.domain.usecases

import com.example.weatherapp.data.models.ForecastResponseDto
import com.example.weatherapp.domain.repository.WeatherRepository

class GetForecastUseCase(private val repository: WeatherRepository) {
    suspend fun execute(location: String, days: Int): ForecastResponseDto {
        return repository.getForecast(location, days)
    }
}