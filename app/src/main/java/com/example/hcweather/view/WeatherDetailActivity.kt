package com.example.hcweather.view


import android.os.Bundle
import android.view.View

import androidx.appcompat.app.AppCompatActivity
import com.example.hcweather.databinding.WeatherDetailActivityBinding
import com.example.hcweather.viewmodel.WeatherDetailViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class WeatherDetailActivity  : AppCompatActivity() {

//    private val viewModel by viewModels<WeatherDetailViewModel>()

    //This is for injecting ViewModel
    private val viewModel : WeatherDetailViewModel by viewModel()

    private lateinit var binding: WeatherDetailActivityBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = WeatherDetailActivityBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val cityName = intent.getStringExtra("cityName")


        // This is a sample of simple Dependency Injection Structure
//        val RetrofitClientInstance = RetrofitClient()
//        val weatherApiInstance = RetrofitClientInstance.getInstance().create(WeatherApi::class.java)
//        val weatherDetailRepositoryInstance = WeatherDetailRepository(weatherApiInstance)
//        viewModel = WeatherDetailViewModel(weatherDetailRepositoryInstance)


        //Function call on ViewModel
        viewModel.getWeather(cityName.toString().lowercase())

        getLiveData()
    }

    private fun getLiveData() {

        //This is mutableLiveData .. can be edited by view Level which is bad
//        viewModel._weatherDataError.value = true

        //This is ImmutableLiveData .. Cannot be Change at UI level (GOOD)
//        viewModel.weatherDataError.value = false


        viewModel.weatherData.observe(this) { data ->
            data?.let {
                //Scope function to shorten or simplify the code
                binding.run {
                    llData.visibility = View.VISIBLE

                    tvCityCode.text = data.sys.country
                    tvCityName.text = data.name

                    tvDegree.text = data.main.temp.toString() + "°C"

                    tvHumidity.text = data.main.humidity.toString() + "%"
                    tvWindSpeed.text = data.wind.speed.toString()
                    tvLat.text = data.coord.lat.toString()
                    tvLon.text = data.coord.lon.toString()
                }

//                binding.llData.visibility = View.VISIBLE
//
//                binding.tvCityCode.text = data.sys.country
//                binding.tvCityName.text = data.name
//
//
//                binding.tvDegree.text = data.main.temp.toString() + "°C"
//
//                binding.tvHumidity.text = data.main.humidity.toString() + "%"
//                binding.tvWindSpeed.text = data.wind.speed.toString()
//                binding.tvLat.text = data.coord.lat.toString()
//                binding.tvLon.text = data.coord.lon.toString()

            }
        }

        viewModel.weatherDataError.observe(this) { error ->
            error?.let {
                if (error) {
                    binding.tvError.visibility = View.VISIBLE
                    binding.pbLoading.visibility = View.GONE
                    binding.llData.visibility = View.GONE
                } else {
                    binding.tvError.visibility = View.GONE
                }
            }
        }


    }
}