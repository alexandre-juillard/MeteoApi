package com.example.meteoapp.network

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class CurrentUnits(
    val time: String,
    val interval: String,

    @SerialName("temperature_2m")
    val temperature: String,

    @SerialName("wind_speed_10m")
    val windSpeed: String
)
