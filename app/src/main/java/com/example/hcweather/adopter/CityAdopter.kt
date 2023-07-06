package com.example.hcweather.adopter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.hcweather.R
import com.example.hcweather.model.City
import com.example.hcweather.view.CityListFragment

class CityAdopter(
    listOfCities: ArrayList<City>,
//    private val listener: RecyclerViewEvent
    private val listener: CityListFragment
): RecyclerView.Adapter<CityAdopter.ViewHolder>() {

    private var listOfCities: ArrayList<City>

    init{
        this.listOfCities = listOfCities
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView), View.OnClickListener{
        val id = itemView.findViewById<TextView>(R.id.cityId)
        val cityName = itemView.findViewById<TextView>(R.id.cityName)

        init {
            itemView.setOnClickListener(this)
        }

        override fun onClick(p0: View?) {
            val position = adapterPosition
            if (position != RecyclerView.NO_POSITION) {
                listener.onItemClick(position)
            }

        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val cityView = LayoutInflater.from(parent.context).inflate(R.layout.item_recycler_view_weather_list,parent,false)
        return ViewHolder(cityView)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val city: City = listOfCities.get(position)
        holder.id.setText("id: " + city.id.toString())
        holder.cityName.setText(city.cityName)

    }

    override fun getItemCount(): Int {
        return listOfCities.size
    }

//    interface RecyclerViewEvent{
//        fun onItemClick(position: Int)
//    }


}