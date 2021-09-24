package com.bratin.weatherapp.data.util

import java.lang.Exception
import java.text.SimpleDateFormat
import java.util.*

/**
 * returns true when last update is more than 5 min ago
 */

val simpleDateFormat = SimpleDateFormat("yyyy-mm-dd HH:mm")
private const val FIVE_MIN = 5 * 60 * 1000

fun isUpdateFromServerNeeded(currentTime: String, lastUpdateTime: String): Boolean {
    val currentTimeMillis = (simpleDateFormat.parse(currentTime) as Date).time
    val lastUpdateTimeMillis = (simpleDateFormat.parse(lastUpdateTime) as Date).time
    return lastUpdateTimeMillis + FIVE_MIN < currentTimeMillis
}