package com.sokhal.weatherapp

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class WeatherCallbackController {
    private  val service = GeoNamesWeatherService()

    fun loadWeather(
        latitude: Double,
        longitude: Double,
        onSuccess:(WeatherObservation)-> Unit,
        onError:(String)-> Unit
    ){
        CoroutineScope(Dispatchers.Default).launch {
            try {
                val weather=service.getNearWeather(latitude,longitude)
                onSuccess(weather)
            }
            catch (e: Exception){
                onError(e.message ?:"Unable to load the Weather Report")
            }
        }

    }

}