package com.bratin.weatherapp.domain.models

/**
 * Weather Data model
 */
data class WeatherData(
    val weatherCondition: String,
    val iconUrl: String,
    val visibility: Double,
    val uvIndex: Double,
    val temp: Double,
    val feelsLikeTemp: Double,
    val pressure: Double,
    val windSpeed: Double,
    val lastUpdated: String
)
