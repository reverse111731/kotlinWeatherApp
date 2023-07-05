package com.example.hcweather.services

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface WeatherApi {

    @GET("data/2.5/weather")
    suspend fun getData(
        @Query("q") cityName: String,
        @Query("units") units: String = "metric",
        @Query("appid") id: String ="79606421b40eac4780d23b69202b4a56",
    ): Response<WeatherResponse>
}