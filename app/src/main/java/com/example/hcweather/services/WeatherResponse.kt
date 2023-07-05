package com.example.hcweather.services

import com.example.hcweather.model.WeatherModel
import com.google.gson.annotations.SerializedName

//data class Coord(
//    val lon: Double,
//    val lat: Double
//)
//data class Main(
//    val temp: Double,
//    @SerializedName("temp_max")
//    val tempMax: Double,
//    @SerializedName("temp_min")
//    val tempMin: Double,
//    val humidity: Int
//)
//data class Sys(
//    val id: Int,
//    val country: String,
//    val sunRise: Int,
//    val sunSet: Int,
//)
//data class Wind(
//    val gust: Double,
//    val speed: Double,
//    val deg: Double
//)

// This is the remote model because of API response
data class WeatherResponse(
    val name: String,
    val dt: Int,
    val id: Int,
    val timeZone: Int,
    val visibility: Int,
    val coord: CoordResponse,
    val main: MainReponse,
    val sys: SysResponse,
    val wind: WindResponse
) {
    data class CoordResponse(
        val lon: Double,
        val lat: Double
    )

    data class MainReponse(
        val temp: Double,
        @SerializedName("temp_max")
        val tempMax: Double,
        @SerializedName("temp_min")
        val tempMin: Double,
        val humidity: Int
    )

    data class SysResponse(
        val id: Int,
        val country: String,
        val sunRise: Int,
        val sunSet: Int,
    )

    data class WindResponse(
        val gust: Double,
        val speed: Double,
        val deg: Double
    )
}

fun WeatherResponse.transformToModel(): WeatherModel {
    return WeatherModel(
        name = name,
        dt = dt,
        timeZone = timeZone,
        id = id,
        visibility = visibility,
        coord = WeatherModel.CoorModel(
            lon = coord.lon,
            lat = coord.lat,
        ),
        main = WeatherModel.MainModel(
            temp = main.temp,
            tempMax = main.tempMax,
            tempMin = main.tempMin,
            humidity = main.humidity,
        ),
        sys = WeatherModel.SysModel(
            id = sys.id,
            country = sys.country,
            sunRise = sys.sunRise,
            sunSet = sys.sunSet,
        ),
        wind = WeatherModel.WindModel(
            gust = wind.gust,
            speed = wind.speed,
            deg = wind.deg
        )
    )
}

//fun WeatherResponse.tranformToWeatherDetailModel(): WeatherDetailModel {
//    return WeatherDetailModel(
//        temp = main.temp,
//        humidity = main.humidity,
//        country = sys.country,
//        cityName = name,
//        windSpeed = wind.speed,
//        lon = coord.lon,
//        lat = coord.lat,
//    )
//}