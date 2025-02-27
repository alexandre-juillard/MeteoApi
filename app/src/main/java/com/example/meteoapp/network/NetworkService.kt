package com.example.meteoapp.network

import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import retrofit2.Retrofit
import retrofit2.http.GET
import retrofit2.http.Query

private const val BASE_URL =
    "https://api.open-meteo.com/"

private val retrofit = Retrofit.Builder()
    .addConverterFactory(Json.asConverterFactory("application/json".toMediaType()))
    .baseUrl(BASE_URL)
    .build()

interface MeteoApiService {
    @GET("v1/forecast")
    suspend fun getMeteo(
        @Query("latitude") latitude: Double,
        @Query("longitude") longitude: Double,
        @Query("current") current: String = "temperature_2m,wind_speed_10m"): Meteo
}

object MeteoApi {
    val retrofitService: MeteoApiService by lazy {
        retrofit.create(MeteoApiService::class.java)
    }
}