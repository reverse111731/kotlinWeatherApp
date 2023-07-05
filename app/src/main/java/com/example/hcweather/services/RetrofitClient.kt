package com.example.hcweather.services

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitClient {

    private val baseURl = "http://api.openweathermap.org/"

    fun getInstance(): Retrofit {
        return Retrofit.Builder()
            .baseUrl(baseURl)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
}