package com.example.hcweather.repository

import com.example.hcweather.model.WeatherModel
import com.example.hcweather.services.WeatherApi
import com.example.hcweather.services.transformToModel


class WeatherDetailRepositoryImpl(
    val weatherAPI: WeatherApi
    ) : WeatherDetailRepository {

    override suspend fun getDataFromAPI(cityName: String): WeatherModel? {
        val response = weatherAPI.getData(cityName)

        //This will return a deserialize API response
        return response.body()?.transformToModel()
    }

//    override suspend fun getWeatherDetails(cityName: String): WeatherDetailModel? {
//        val data = getDataFromAPI(cityName)
//        return data
//    }
}