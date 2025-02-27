package com.example.meteoapp.network

import kotlinx.serialization.SerialName

data class Current(
    val time: String,
    val interval: Int,

    @SerialName("temperature_2m")
    val temperature: Int,

    @SerialName("wind_speed_10m")
    val windSpeed: Double,
)
