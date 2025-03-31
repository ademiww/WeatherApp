package com.example.weatherapp.di.presentation

import com.example.weatherapp.domain.usecases.GetForecastUseCase
import com.example.weatherapp.domain.usecases.GetWeatherUseCase
import org.koin.dsl.module


val useCaseModule = module {
    factory { GetWeatherUseCase(repository = get()) }
    factory { GetForecastUseCase(repository = get()) }
}