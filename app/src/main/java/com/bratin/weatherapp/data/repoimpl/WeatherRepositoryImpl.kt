package com.bratin.weatherapp.data.repoimpl

import com.bratin.weatherapp.data.mapper.WeatherDataMapper
import com.bratin.weatherapp.data.source.WeatherDataSource
import com.bratin.weatherapp.domain.models.WeatherData
import com.bratin.weatherapp.domain.repository.WeatherRepository
import javax.inject.Inject

class WeatherRepositoryImpl @Inject constructor(
    private val weatherDataSource: WeatherDataSource,
    private val weatherDataMapper: WeatherDataMapper
) : WeatherRepository {

    override suspend fun getWeatherData(query: String): WeatherData? =
        weatherDataMapper.mapToEntityFromDto(weatherDataSource.getWeatherData(query))
}