package com.example.hcweather.viewmodel

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.example.hcweather.model.WeatherModel
import com.example.hcweather.repository.WeatherDetailRepository

// Junit
import org.junit.Before
import org.junit.Test
import org.junit.Assert.*
import org.junit.Rule
import org.junit.rules.TestWatcher
import org.junit.runner.Description

// mockk
import io.mockk.MockKAnnotations
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.impl.annotations.MockK

// coroutines
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.test.TestCoroutineDispatcher
import kotlinx.coroutines.test.TestCoroutineScope
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.runBlockingTest
import kotlinx.coroutines.test.setMain
import strikt.api.expectThat
import strikt.assertions.isEqualTo


class MainCoroutineRule(
    val testDispatcher: TestCoroutineDispatcher = TestCoroutineDispatcher()
) : TestWatcher() {

    override fun starting(description: Description) {
        super.starting(description)
        Dispatchers.setMain(testDispatcher)
    }

    override fun finished(description: Description) {
        super.finished(description)
        Dispatchers.resetMain()
        testDispatcher.cleanupTestCoroutines()
    }

    fun runBlockingTest(block: suspend TestCoroutineScope.() -> Unit) =
        testDispatcher.runBlockingTest(block)
}


class WeatherDetailViewModelTest{

    @get:Rule
    val mainCoroutineRule = MainCoroutineRule()

    @get:Rule
    val instantTaskExecutorRule = InstantTaskExecutorRule()

    @MockK
    private lateinit var weatherDetailRepository: WeatherDetailRepository
    private lateinit var viewModel: WeatherDetailViewModel
    private val cityName = "manila"

    @Before
    fun setUp(){
        MockKAnnotations.init(this)
        viewModel = WeatherDetailViewModel(weatherDetailRepository)
    }

    @Test
    fun checkAPI(){

        // Arrange
        coEvery {
            weatherDetailRepository.getDataFromAPI(cityName)
        } returns TestObject.mockWeather

        //Act
        viewModel.getWeather(cityName)

        // Verify if it was called
        coVerify {
            weatherDetailRepository.getDataFromAPI(cityName)
        }

//        expectThat(viewModel.getWeather(cityName)).isEqualTo(TestObject.mockWeather)
    }

//    @Test
//    fun callAddition(){
//        assertEquals(4, viewModel.addition(5,2))
//    }

}



internal object TestObject{
    val mockWeather = WeatherModel(
        name = "manila",
        wind = WeatherModel.WindModel(
            gust = 12.12,
            speed = 33.44,
            deg = 55.5
        ),
        main = WeatherModel.MainModel(
            temp = 33.333,
            tempMax = 444.44,
            tempMin = 111.11,
            humidity = 12,
        ),
        sys = WeatherModel.SysModel(
            sunSet = 123,
            sunRise = 456,
            id = 123,
            country = "ph"
        ),
        id = 1234567,
        coord = WeatherModel.CoorModel(
            lon = 98765.4321,
            lat = 12345.67890,
        ),
        dt = 22,
        timeZone = 12344,
        visibility = 333333,
    )
}