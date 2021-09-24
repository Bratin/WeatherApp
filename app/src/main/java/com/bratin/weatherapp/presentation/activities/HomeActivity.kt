package com.bratin.weatherapp.presentation.activities

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.bratin.weatherapp.databinding.ActivityHomeBinding
import com.bratin.weatherapp.presentation.viewModels.HomeViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeActivity : AppCompatActivity() {
    private val homeViewModel: HomeViewModel by viewModels()

    private lateinit var binding: ActivityHomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        initWeatherDataObserver()
        homeViewModel.getWeatherData("auto:ip")
    }

    private fun initWeatherDataObserver() {
        homeViewModel.weatherLiveData.observe(this) { weatherData ->
            if (weatherData != null)
                binding.weatherCard.setWeatherData(weatherData)
        }
    }
}