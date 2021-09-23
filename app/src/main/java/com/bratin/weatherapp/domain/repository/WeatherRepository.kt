package com.bratin.weatherapp.domain.repository

import com.bratin.weatherapp.domain.models.WeatherData

interface WeatherRepository {
    suspend fun getWeatherData(query: String): WeatherData?
}