package com.example.hcweather.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.hcweather.R
import com.example.hcweather.adopter.CityAdopter
import com.example.hcweather.databinding.ActivityMainBinding
import com.example.hcweather.model.Constant

// TODO make into a single activity with the rest being fragments
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private var cityList = Constant.getListOfCities()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val adopter = CityAdopter(cityList,this)

        binding.listOfCities.adapter = adopter
        binding.listOfCities.layoutManager = LinearLayoutManager(this)
        binding.listOfCities.isNestedScrollingEnabled = false

    }

    fun onItemClick(position: Int) {
        val cityName = cityList[position]

        Intent(this,WeatherDetailActivity::class.java).also {
            it.putExtra(
                "cityName",
                cityName.cityName
            )
            startActivity(it)
        }
//        Toast.makeText(
//            this,
//            cityName.cityName,
//            Toast.LENGTH_SHORT
//        ).show()
    }
}