package com.bratin.weatherapp.data.models

import com.google.gson.annotations.SerializedName

data class WeatherDataResponse(val current: Current)

data class Current(
    val condition: Condition,
    val temp_c: Double,
    @SerializedName("feelslike_c")
    val feels_like_c: Double,
    val wind_kph: Double,
    val uv: Double,
    val vis_km: Double,
    val pressure_mb: Double,
    val last_updated: String
)

data class Condition(val text: String, val icon: String)
