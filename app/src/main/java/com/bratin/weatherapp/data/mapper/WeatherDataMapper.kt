package com.bratin.weatherapp.data.mapper

import com.bratin.weatherapp.data.models.WeatherDataResponse
import com.bratin.weatherapp.domain.models.WeatherData
import javax.inject.Inject

class WeatherDataMapper @Inject constructor() : BaseMapper<WeatherDataResponse, WeatherData> {

    override fun mapToEntityFromDto(data: WeatherDataResponse?) = data?.current?.let {
        WeatherData(
            weatherCondition = it.condition.text,
            temp = it.temp_c,
            feelsLikeTemp = it.feels_like_c,
            lastUpdated = it.last_updated,
            pressure = it.pressure_mb,
            uvIndex = it.uv,
            visibility = it.vis_km,
            iconUrl = "https:" + it.condition.icon,
            windSpeed = it.wind_kph
        )
    }
}