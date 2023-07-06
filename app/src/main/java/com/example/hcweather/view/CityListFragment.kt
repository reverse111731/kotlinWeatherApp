package com.example.hcweather.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.hcweather.adopter.CityAdopter
import com.example.hcweather.databinding.RecyclerViewFragmentBinding
import com.example.hcweather.model.Constant

class CityListFragment: Fragment() {

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