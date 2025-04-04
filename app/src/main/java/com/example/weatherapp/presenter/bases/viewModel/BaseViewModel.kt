package com.example.weatherapp.presenter.bases.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.weatherapp.presenter.viewmodel.HomeViewModel
import com.example.weatherapp.utils.Either
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch

abstract class BaseViewModel(
    private val mainDispatcher: CoroutineDispatcher
) : ViewModel() {
    protected fun <T> collectFlow(
        state: MutableStateFlow<HomeViewModel.UIState<T>>,
        request: suspend () -> Flow<Either<Throwable, T>>
    ) {
        viewModelScope.launch(mainDispatcher) {
            state.value = HomeViewModel.UIState.Loading
            request().collect { result ->
                when (result) {
                    is Either.Success -> state.value = HomeViewModel.UIState.Success(result.data)
                    is Either.Error -> state.value = HomeViewModel.UIState.Error(result.error.message ?: "Ошибка")
                }
            }
        }
    }
}