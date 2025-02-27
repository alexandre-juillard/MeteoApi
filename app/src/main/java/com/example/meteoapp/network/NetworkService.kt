package com.example.meteoapp.network

import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import retrofit2.Retrofit
import retrofit2.http.GET

private const val BASE_URL =
    "https://open-meteo.com/"

private val retrofit = Retrofit.Builder()
    .addConverterFactory(Json.asConverterFactory("application/json".toMediaType()))
    .baseUrl(BASE_URL)
    .build()

interface MeteoApiService {
    @GET("v1/forecast?latitude=52.52&longitude=13.41&current=temperature_2m,wind_speed_10m")
    suspend fun getMeteo(): Meteo
}

object MeteoApi {
    val retrofitService: MeteoApiService by lazy {
        retrofit.create(MeteoApiService::class.java)
    }
}