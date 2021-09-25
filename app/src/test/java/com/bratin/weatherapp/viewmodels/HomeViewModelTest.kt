package com.bratin.weatherapp.viewmodels

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.bratin.weatherapp.BaseTest
import com.bratin.weatherapp.domain.models.WeatherData
import com.bratin.weatherapp.domain.usecase.WeatherUseCase
import com.bratin.weatherapp.presentation.viewModels.HomeViewModel
import kotlinx.coroutines.runBlocking
import org.junit.Assert.assertNotNull
import org.junit.Assert.assertNull
import org.junit.Rule
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito.`when`

class HomeViewModelTest : BaseTest() {
    private lateinit var viewModel: HomeViewModel

    @Mock
    private lateinit var useCase: WeatherUseCase

    @Mock
    private lateinit var weatherData: WeatherData

    @get:Rule
    val instantTaskExecutorRule = InstantTaskExecutorRule()

    override fun setup() {
        super.setup()
        viewModel = HomeViewModel(useCase)
    }

    @Test
    fun getWeatherData_Success() {
        runBlocking {
            `when`(useCase.getWeatherData(QUERY)).thenReturn(weatherData)
            viewModel.getWeatherData(QUERY)
            val weatherData = viewModel.weatherLiveData.value
            assertNotNull(weatherData)
        }
    }

    @Test
    fun getWeatherData_returnsNull() {
        runBlocking {
            `when`(useCase.getWeatherData(QUERY)).thenReturn(null)
            viewModel.getWeatherData(QUERY)
            val weatherData = viewModel.weatherLiveData.value
            assertNull(weatherData)
        }
    }

    private companion object {
        private const val QUERY = "test"
    }
}