package com.example.hcweather.repository

import com.example.hcweather.model.WeatherModel
import com.example.hcweather.services.WeatherApi

//Todo Make this into a repository pattern - check
//Todo Make into a repository interface - check
class WeatherDetailRepositoryImpl(val weatherAPI: WeatherApi) : WeatherDetailRepository {

    //This will return the WeatherModel instead of API response
//    suspend fun getDataFromAPI(cityName: String) : WeatherModel?{
//        val response = weatherAPI.getData(cityName)
//
//        //This will return a deserialize API response
//        return response.body()
//    }

    override suspend fun getDataFromAPI(cityName: String): WeatherModel? {
        val response = weatherAPI.getData(cityName)

        //This will return a deserialize API response
        return response.body()
    }
}