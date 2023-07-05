package com.example.hcweather.repository

import com.example.hcweather.model.WeatherModel
import com.example.hcweather.services.WeatherResponse

interface WeatherDetailRepository {

    suspend fun getDataFromAPI(cityName : String) : WeatherModel?

//    suspend fun getDataFromAPI(cityName: String) : WeatherDetailModel?
}