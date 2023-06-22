package com.example.hcweather.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.hcweather.model.WeatherModel
import com.example.hcweather.repository.WeatherDetailRepositoryImpl

import kotlinx.coroutines.launch
import java.lang.Exception

class WeatherDetailViewModel(
    private val weatherDetailRepository: WeatherDetailRepositoryImpl
) : ViewModel(){

    private val _weatherData = MutableLiveData<WeatherModel?>()
    val weatherData: LiveData<WeatherModel?> = _weatherData

    private val _weatherDataError = MutableLiveData<Boolean>()
    val weatherDataError: LiveData<Boolean> = _weatherDataError


    fun getWeather(cityName: String){
        viewModelScope.launch {
            try {
                val result = weatherDetailRepository.getDataFromAPI(cityName)
//            weatherData.postValue(result)
                _weatherData.value = result
            } catch (e: Exception) {
                e.printStackTrace()
                Log.e("some weird Error", "${e.message}")
                _weatherDataError.value = true
            }


        }
    }
}