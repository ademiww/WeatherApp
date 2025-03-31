package com.example.weatherapp.di.presentation

import com.example.weatherapp.presentation.viewModel.WeatherViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.scope.get
import org.koin.dsl.module

val viewModelModule = module {
    viewModel { WeatherViewModel(getWeatherUseCase = get(), getForecastUseCase = get()) }
}