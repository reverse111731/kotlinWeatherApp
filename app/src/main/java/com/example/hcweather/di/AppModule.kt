package com.example.hcweather.di

import com.example.hcweather.repository.WeatherDetailRepository
import com.example.hcweather.repository.WeatherDetailRepositoryImpl
import com.example.hcweather.services.RetrofitClient
import com.example.hcweather.services.WeatherApi
import com.example.hcweather.viewmodel.WeatherDetailViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

val appModule = module {

    //Create a single instance (singleton)
    single {
        RetrofitClient().getInstance().create(WeatherApi::class.java)
    }

    //Single instance of WeatherDetailsRepositoryImpl
    //get() -> This get the created instance within the file
    single <WeatherDetailRepository>{
        WeatherDetailRepositoryImpl(get())
    }

    // This get the single instance of WeatherDetail Repository
    viewModel {
        WeatherDetailViewModel(get())
    }


    // This will create a new instance everytime it is called
//    factory {
//        MainRepositoryImpl(get())
//    }

}