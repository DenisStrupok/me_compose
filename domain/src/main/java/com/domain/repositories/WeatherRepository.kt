package com.domain.repositories

interface WeatherRepository {

    suspend fun getWeather()
}