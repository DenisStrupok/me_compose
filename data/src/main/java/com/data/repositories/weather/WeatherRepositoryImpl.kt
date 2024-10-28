package com.data.repositories.weather

import com.domain.repositories.WeatherRepository

class WeatherRepositoryImpl : WeatherRepository {
    override suspend fun getWeather() {
        val test = 0
        test.toString()
    }
}