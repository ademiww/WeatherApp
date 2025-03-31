package com.example.weatherapp.data.datasource

import com.example.weatherapp.data.models.CurrentWeatherResponseDto
import com.example.weatherapp.data.models.ForecastResponseDto
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {
    @GET("current.json")
    suspend fun getCurrentWeather(
        @Query ("key") apiKey: String,
        @Query ("q") location: String
    ) : CurrentWeatherResponseDto

    @GET ("forecast.json")
    suspend fun getForecast(
        @Query ("key") apiKey: String,
        @Query ("q") location: String,
        @Query("days") days: Int
    ) : ForecastResponseDto
}