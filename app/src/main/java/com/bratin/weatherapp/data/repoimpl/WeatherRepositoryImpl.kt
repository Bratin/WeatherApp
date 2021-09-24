package com.bratin.weatherapp.data.repoimpl

import com.bratin.weatherapp.data.db.AppDatabase
import com.bratin.weatherapp.data.mapper.WeatherDataMapper
import com.bratin.weatherapp.data.source.WeatherDataSource
import com.bratin.weatherapp.data.util.isUpdateFromServerNeeded
import com.bratin.weatherapp.data.util.simpleDateFormat
import com.bratin.weatherapp.domain.models.WeatherData
import com.bratin.weatherapp.domain.repository.WeatherRepository
import java.util.*
import javax.inject.Inject

class WeatherRepositoryImpl @Inject constructor(
    private val weatherDataSource: WeatherDataSource,
    private val weatherDataMapper: WeatherDataMapper,
    private val database: AppDatabase
) : WeatherRepository {
    private var weatherData: WeatherData? = null

    override suspend fun getWeatherData(query: String): WeatherData? {
        weatherData = database.weatherDao().loadWeatherData(query)

        weatherData?.let {
            if (isUpdateFromServerNeeded(simpleDateFormat.format(Date()), it.lastUpdated)) {
                callServer(query)
            }
        } ?: callServer(query)
        return database.weatherDao().loadWeatherData(query)
    }

    private suspend fun callServer(query: String) {
        weatherData =
            weatherDataMapper.mapToEntityFromDto(weatherDataSource.getWeatherData(query))
        weatherData?.let {
            it.query = query
            it.lastUpdated = simpleDateFormat.format(Date())
            database.weatherDao().insert(it)
        }
    }
}