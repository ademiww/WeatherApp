package com.example.weatherapp.data.repository

import com.example.weatherapp.data.datasource.ApiService
import com.example.weatherapp.data.models.CurrentWeatherResponseDto
import com.example.weatherapp.data.models.ForecastResponseDto
import com.example.weatherapp.domain.repository.WeatherRepository

class CurrentWeatherRepositoryImpl (
    private val api : ApiService
) : WeatherRepository {

    override suspend fun getCurrentWeather(location: String): CurrentWeatherResponseDto {
        return api.getCurrentWeather(apiKey = "bf9a232a020143baa23133340252703", location = location)
    }

    override suspend fun getForecast(location: String, days: Int): ForecastResponseDto {
        return api.getForecast(apiKey = "bf9a232a020143baa23133340252703", location = location, days = days)
    }
}