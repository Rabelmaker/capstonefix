package com.akbar.capstone2.model


import com.akbar.capstone2.R
import java.time.Clock

data class WeatherModel(
    val icon: Int,
    val temp: String,
    val city: String,
    val clock: String,
    val humadity: String,
    val windspeed: String,
)

val dummyWeather = listOf(
    WeatherModel(R.drawable.day, "25", "Pekanbaru","12:00 PM", "50", "10"),
    WeatherModel(R.drawable.sun, "29", "Pekanbaru","01:00 PM", "70", "10"),
    WeatherModel(R.drawable.cloudy, "23", "Pekanbaru","03:00 PM", "50", "10"),
    WeatherModel(R.drawable.rain, "21", "Pekanbaru","04:00 PM", "50", "30"),
)
