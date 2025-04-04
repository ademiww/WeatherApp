package com.example.weatherapp.di

import com.example.weatherapp.di.corutines.dispatcherModule
import com.example.weatherapp.di.data.networkModule
import com.example.weatherapp.di.domain.domainModule
import com.example.weatherapp.di.presentation.presentationModule

val appModule =
    listOf( domainModule, presentationModule, networkModule, dispatcherModule)