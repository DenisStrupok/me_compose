package com.data.di

import com.data.repositories.weather.WeatherRepositoryImpl
import com.domain.repositories.WeatherRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object DataModules {

    @Provides
    fun provideWeatherModule(): WeatherRepository {
        return WeatherRepositoryImpl()
    }
}