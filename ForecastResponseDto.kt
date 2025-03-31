package com.example.weatherapp.data.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ForecastResponseDto(
    @SerialName("forecast")
    val forecast: Forecast
) {
    @Serializable
    data class Forecast(
        @SerialName("forecastDay")
        val forecastDay: List<ForecastDay>
    ) {
        @Serializable
        data class ForecastDay(
            @SerialName("day")
            val day: Day
        ) {
            @Serializable
            data class Day(
                @SerialName("avgtemp_c")
                val avgTempC: Double
            )
        }
    }
}