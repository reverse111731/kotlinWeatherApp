package com.example.hcweather.view

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.setFragmentResultListener
import androidx.navigation.fragment.navArgs
import com.example.hcweather.databinding.WeatherDetailFragmentBinding
import com.example.hcweather.viewmodel.WeatherDetailViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class WeatherDetailFragment: Fragment() {

    private lateinit var binding: WeatherDetailFragmentBinding

    //This is an android delegate
    private val viewModel : WeatherDetailViewModel by viewModel()

    //This is an android delegate
    // This will accept the arguments pass from the previous fragments
    private val args: WeatherDetailFragmentArgs by navArgs()

//    private val sharedViewModel: WeatherDetailViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = WeatherDetailFragmentBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.getWeather(args.cityName)
        getLiveData()
    }



    private fun getLiveData() {
        viewModel.weatherData.observe(viewLifecycleOwner) { data ->
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
            }
        }

        viewModel.weatherDataError.observe(viewLifecycleOwner) { error ->
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
