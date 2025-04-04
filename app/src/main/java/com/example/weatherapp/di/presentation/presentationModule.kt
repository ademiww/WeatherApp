package com.example.weatherapp.di.presentation

import com.example.weatherapp.presenter.viewmodel.HomeViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.qualifier.named
import org.koin.dsl.module


val presentationModule = module {
    viewModel {
        HomeViewModel(
            getTextUseCase = get(),
            mainDispatcher = get(named("Main"))
        )
    }
}