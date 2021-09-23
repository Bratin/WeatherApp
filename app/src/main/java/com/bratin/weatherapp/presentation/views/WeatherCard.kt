package com.bratin.weatherapp.presentation.views

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import androidx.constraintlayout.widget.ConstraintLayout
import com.bratin.weatherapp.R
import com.bratin.weatherapp.databinding.WeatherCardBinding
import com.bratin.weatherapp.domain.models.WeatherData
import com.squareup.picasso.Picasso
import java.text.DecimalFormat

/**
 * Weather card view, shows all weather info
 */
class WeatherCard constructor(
    context: Context,
    attrs: AttributeSet? = null
) : ConstraintLayout(context, attrs, 0) {

    private val binding = WeatherCardBinding.inflate(LayoutInflater.from(context), this, true)
    private val tempFormat = DecimalFormat("#.#")

    fun setWeatherData(data: WeatherData) {
        binding.apply {
            Picasso.get().load(data.iconUrl).resize(IMAGE_SIZE, IMAGE_SIZE).into(weatherImg)
            weatherCondition.text = data.weatherCondition
            temperature.text = String.format(
                context.getString(R.string.temp),
                tempFormat.format(data.feelsLikeTemp)
            )
            feelsLike.text = String.format(
                context.getString(R.string.feels_like),
                tempFormat.format(data.feelsLikeTemp)
            )
            pressure.text = String.format(
                context.getString(R.string.pressure),
                tempFormat.format(data.pressure)
            )
            windSpeed.text = String.format(
                context.getString(R.string.wind_speed),
                tempFormat.format(data.windSpeed)
            )
            visibility.text = String.format(
                context.getString(R.string.visibility),
                tempFormat.format(data.visibility)
            )
            uv.text = String.format(
                context.getString(R.string.uv_index),
                tempFormat.format(data.uvIndex)
            )
        }
    }

    private companion object {
        private const val IMAGE_SIZE = 150
    }
}
