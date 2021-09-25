package com.bratin.weatherapp.data.repoimpl

import com.bratin.weatherapp.BaseTest
import com.bratin.weatherapp.data.db.AppDatabase
import com.bratin.weatherapp.data.mapper.WeatherDataMapper
import com.bratin.weatherapp.data.source.WeatherDataSource
import com.bratin.weatherapp.domain.models.WeatherData
import com.bratin.weatherapp.domain.repository.WeatherRepository
import kotlinx.coroutines.runBlocking
import org.junit.Assert.assertNotNull
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito.`when`

class WeatherRepositoryImplTest : BaseTest() {

    @Mock
    private lateinit var appDatabase: AppDatabase

    @Mock
    private lateinit var weatherDataSource: WeatherDataSource

    @Mock
    private lateinit var weatherDataMapper: WeatherDataMapper

    @Mock
    private lateinit var weatherData: WeatherData

    private lateinit var weatherRepository: WeatherRepository

    override fun setup() {
        super.setup()
        weatherRepository =
            WeatherRepositoryImpl(weatherDataSource, weatherDataMapper, appDatabase)
    }

    @Test
    fun getWeatherDataTest() {
        runBlocking {
            `when`(weatherRepository.getWeatherData(QUERY)).thenReturn(weatherData)
            val data = weatherRepository.getWeatherData(QUERY)
            assertNotNull(data)
        }
    }

    private companion object {
        private const val QUERY = "test"
    }
}