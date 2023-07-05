package com.example.hcweather.model

import com.example.hcweather.repository.WeatherDetailRepository
import com.example.hcweather.services.WeatherResponse
import com.google.gson.annotations.SerializedName

data class WeatherModel(
    val name: String,
    val dt: Int,
    val id: Int,
    val timeZone: Int,
    val visibility: Int,
    val coord : CoorModel,
    val main: MainModel,
    val sys: SysModel,
    val wind: WindModel
){
    data class CoorModel(
        val lon: Double,
        val lat: Double
    )
    data class MainModel(
        val temp: Double,
        val tempMax: Double,
        val tempMin: Double,
        val humidity: Int
    )
    data class SysModel(
        val id: Int,
        val country: String,
        val sunRise: Int,
        val sunSet: Int,
    )
    data class WindModel(
        val gust: Double,
        val speed: Double,
        val deg: Double
    )
}

//fun WeatherModel.tranformToWeatherDetailModel(): WeatherDetailModel{
//    return WeatherDetailModel(
//
//        temp = main.temp,
//        humidity = main.humidity,
//        country = sys.country,
//        cityName = name,
//        windSpeed = wind.speed,
//        lon = coord.lon,
//        lat = coord.lat,
//    )
//}