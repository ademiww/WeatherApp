package com.example.weatherapp.di.domain

import com.example.weatherapp.domain.usecases.GetTextUseCase
import org.koin.dsl.module


val domainModule = module {
    single { GetTextUseCase(apiRepository = get()) }

}