package com.example.meteoapp.network

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Current(
    val time: String,
    val interval: Double,

    @SerialName("temperature_2m")
    val temperature: Double,

    @SerialName("wind_speed_10m")
    val windSpeed: Double,
)
