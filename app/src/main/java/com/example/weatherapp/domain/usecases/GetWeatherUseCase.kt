package com.example.weatherapp.domain.usecases

import com.example.weatherapp.data.models.CurrentWeatherResponseDto
import com.example.weatherapp.domain.repository.WeatherRepository

class GetWeatherUseCase(private val repository: WeatherRepository) {
    suspend fun execute(location:String) : CurrentWeatherResponseDto {
        return repository.getCurrentWeather(location)
    }
}