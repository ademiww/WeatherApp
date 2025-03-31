package com.example.weatherapp.domain.repository

import com.example.weatherapp.data.models.CurrentWeatherResponseDto
import com.example.weatherapp.data.models.ForecastResponseDto

interface WeatherRepository {
    suspend fun getCurrentWeather(location: String): CurrentWeatherResponseDto
    suspend fun getForecast(location: String, days: Int): ForecastResponseDto
}