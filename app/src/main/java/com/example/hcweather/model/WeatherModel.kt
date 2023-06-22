package com.example.hcweather.model

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
data class WeatherModel(
    val name: String,
    val dt: Int,
    val id: Int,
    val timeZone: Int,
    val visibility: Int,
    val coord : Coord,
    val main: Main,
    val sys: Sys,
    val wind: Wind
){
    data class Coord(
    val lon: Double,
    val lat: Double
)
data class Main(
    val temp: Double,
    @SerializedName("temp_max")
    val tempMax: Double,
    @SerializedName("temp_min")
    val tempMin: Double,
    val humidity: Int
)
data class Sys(
    val id: Int,
    val country: String,
    val sunRise: Int,
    val sunSet: Int,
)
data class Wind(
    val gust: Double,
    val speed: Double,
    val deg: Double
)
}
