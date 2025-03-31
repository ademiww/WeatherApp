package com.example.weatherapp.di.presentation

import com.example.weatherapp.data.repository.CurrentWeatherRepositoryImpl
import com.example.weatherapp.domain.repository.WeatherRepository
import org.koin.dsl.module

val repositoryModule = module {
    single<WeatherRepository> { CurrentWeatherRepositoryImpl(api = get()) }
}