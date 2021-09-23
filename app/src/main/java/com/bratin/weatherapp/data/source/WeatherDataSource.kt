package com.bratin.weatherapp.data.source

import com.bratin.weatherapp.data.models.WeatherDataResponse
import com.bratin.weatherapp.data.service.APIService
import com.bratin.weatherapp.data.service.EndPoint.API_KEY
import com.bratin.weatherapp.data.service.EndPoint.ENDPOINT_WEATHER_DATA
import javax.inject.Inject

class WeatherDataSource @Inject constructor(
    private val apiService: APIService
) {
    suspend fun getWeatherData(query: String): WeatherDataResponse? =
        apiService.getWeatherData(API_KEY, query)
}