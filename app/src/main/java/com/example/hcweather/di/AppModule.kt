package com.example.hcweather.di

import com.example.hcweather.repository.WeatherDetailRepositoryImpl
import com.example.hcweather.services.RetrofitClient
import com.example.hcweather.services.WeatherApi
import com.example.hcweather.viewmodel.WeatherDetailViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule = module {



    //Create a single instance (singleton)
    single {
        RetrofitClient().getInstance().create(WeatherApi::class.java)
    }

    //Single instance of WeatherDetails
    //get() -> This get the created instance within the file
    single {
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