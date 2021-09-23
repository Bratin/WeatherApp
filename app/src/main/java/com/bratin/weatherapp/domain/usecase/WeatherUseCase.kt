package com.bratin.weatherapp.domain.usecase

import com.bratin.weatherapp.domain.models.WeatherData
import com.bratin.weatherapp.domain.repository.WeatherRepository
import javax.inject.Inject

class WeatherUseCase @Inject constructor(private val repository: WeatherRepository) {
    suspend fun getWeatherData(query: String): WeatherData? = repository.getWeatherData(query)
}