package com.example.weatherapp.presentation.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.weatherapp.data.models.ForecastResponseDto
import com.example.weatherapp.domain.usecases.GetForecastUseCase
import com.example.weatherapp.domain.usecases.GetWeatherUseCase
import kotlinx.coroutines.launch


class WeatherViewModel(private val getWeatherUseCase: GetWeatherUseCase,
                       private val getForecastUseCase: GetForecastUseCase) : ViewModel() {
    private val _forecast = MutableLiveData<ForecastResponseDto?>()
    val forecast: LiveData<ForecastResponseDto?> get() = _forecast

    private val _errorMessage = MutableLiveData<String?>()
    val errorMessage: LiveData<String?> get() = _errorMessage

    private val _isLoading = MutableLiveData<Boolean>()
    val isLoading: LiveData<Boolean> get() = _isLoading

    fun loadForecast(location: String, days: Int) {
        viewModelScope.launch {
            try {
                _isLoading.value = true
                _forecast.value = getForecastUseCase.execute(location, days)
            } catch (e: Exception) {
                _errorMessage.value = e.message
            } finally {
                _isLoading.value = false
            }
        }
    }
}
