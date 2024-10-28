package com.me.features.weather

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.domain.usecases.weather.GetWeatherUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class WeatherVM @Inject constructor(
    private val getWeatherUseCase: GetWeatherUseCase
) : ViewModel() {

    init {
        getWeather()
    }

    private fun getWeather() {
        viewModelScope.launch {
            getWeatherUseCase.invoke(Unit)
        }
    }
}