package com.example.meteoapp.network

import kotlinx.serialization.SerialName

data class Meteo(
    val latitude: Double,
    val longitude: Double,
    val timezone: String,

    @SerialName("utc_offset_seconds")
    val utcOffsetSeconds: Int,

    val elevation: Int,

    @SerialName("current_units")
    val currentUnit: CurrentUnits,

    val current: Current

)
