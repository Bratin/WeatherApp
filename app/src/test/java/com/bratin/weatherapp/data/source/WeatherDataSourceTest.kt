package com.bratin.weatherapp.data.source

import com.bratin.weatherapp.BaseTest
import com.bratin.weatherapp.data.models.WeatherDataResponse
import com.bratin.weatherapp.data.service.APIService
import kotlinx.coroutines.runBlocking
import org.junit.Assert
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito.`when`

class WeatherDataSourceTest:BaseTest() {

    @Mock
    private lateinit var apiService: APIService

    @Mock
    private lateinit var weatherData: WeatherDataResponse

    private lateinit var weatherDataSource: WeatherDataSource

    override fun setup() {
        super.setup()
        weatherDataSource = WeatherDataSource(apiService)
    }

    @Test
    fun getWeatherDataSourceTest() {
        runBlocking {
            `when`(weatherDataSource.getWeatherData(QUERY)).thenReturn(weatherData)
            val weatherData = weatherDataSource.getWeatherData(QUERY)
            Assert.assertNotNull(weatherData)
        }
    }

    private companion object {
        private const val QUERY = "test"
    }
}