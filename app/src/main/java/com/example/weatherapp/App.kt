package com.example.weatherapp

import android.app.Application
import com.example.weatherapp.di.presentation.networkModule
import com.example.weatherapp.di.presentation.repositoryModule
import com.example.weatherapp.di.presentation.useCaseModule
import com.example.weatherapp.di.presentation.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.GlobalContext.startKoin

class App : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@App)
            modules(
                networkModule,
                repositoryModule,
                useCaseModule,
                viewModelModule)
        }
    }
}