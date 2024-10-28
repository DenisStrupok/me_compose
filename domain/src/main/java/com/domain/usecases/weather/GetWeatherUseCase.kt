package com.domain.usecases.weather

import com.domain.repositories.WeatherRepository
import com.domain.usecases.base.BaseUseCase
import javax.inject.Inject

class GetWeatherUseCase @Inject constructor(
    private val weatherRepository: WeatherRepository
) : BaseUseCase<Unit, String> {
    override suspend fun invoke(params: Unit): String {
        weatherRepository.getWeather()
        return "Success"
    }


}