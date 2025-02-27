package com.example.meteoapp.network

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.JsonIgnoreUnknownKeys

@Serializable
@JsonIgnoreUnknownKeys
data class Meteo(
    val latitude: Double,
    val longitude: Double,
    val timezone: String,

    @SerialName("utc_offset_seconds")
    val utcOffsetSeconds: Int,

    val elevation: Double,

    @SerialName("current_units")
    val currentUnit: CurrentUnits,

    val current: Current

)
