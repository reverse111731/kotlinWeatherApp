package com.example.hcweather.repository

import com.example.hcweather.model.WeatherModel

interface WeatherDetailRepository {

    suspend fun getDataFromAPI(cityName : String) : WeatherModel?
}