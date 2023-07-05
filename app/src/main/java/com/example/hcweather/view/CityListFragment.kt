package com.example.hcweather.view

import android.R
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.setFragmentResult
import androidx.fragment.app.setFragmentResultListener
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.hcweather.adopter.CityAdopter
import com.example.hcweather.databinding.RecyclerViewFragmentBinding
import com.example.hcweather.model.Constant
import com.example.hcweather.viewmodel.WeatherDetailViewModel


class CityListFragment: Fragment() {

    //    private val sharedViewModel: WeatherDetailViewModel by activityViewModels()

    private lateinit var binding: RecyclerViewFragmentBinding

    private var cityList = Constant.getListOfCities()


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = RecyclerViewFragmentBinding.inflate(inflater, container, false)

        val adopter = CityAdopter(cityList, this)

        binding.listOfCities.adapter = adopter
        binding.listOfCities.layoutManager = LinearLayoutManager(requireContext())
        binding.listOfCities.isNestedScrollingEnabled = false

        return binding.root

    }

    fun onItemClick(position: Int) {
        val cityName = cityList[position]

        findNavController().navigate(
            CityListFragmentDirections.actionRecyclerFragmentToWeatherDetailFragment(
                cityName.cityName
            )
        )

    }
}

