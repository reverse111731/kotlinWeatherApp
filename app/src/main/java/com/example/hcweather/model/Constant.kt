package com.example.hcweather.model

object Constant {
    private val listOfCities = ArrayList<City>()

    fun getListOfCities() : ArrayList<City> {
        listOfCities.add(city1)
        listOfCities.add(city2)
        listOfCities.add(city3)
        listOfCities.add(city4)
        listOfCities.add(city5)
        listOfCities.add(city6)
        listOfCities.add(city7)

        return listOfCities
    }
}

private val city1 = City(
    id = 1698829,
    cityName = "Naga"
)

private val city2 = City(
    id = 1701668,
    cityName = "Manila"
)

private val city3 = City(
    id = 1880252,
    cityName = "Singapore"
)
private val city4 = City(
    id = 2643743,
    cityName = "London"
)
private val city5 = City(
    id = 5308655,
    cityName = "Phoenix"
)

private val city6 = City(
    id = 1692214,
    cityName = "Quezon"
)

private val city7 = City(
    id = 1850144,
    cityName = "Tokyo"
)



