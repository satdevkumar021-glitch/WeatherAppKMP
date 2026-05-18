package com.sokhal.weatherapp

import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get
import io.ktor.client.request.parameter
import io.ktor.util.logging.Logger

class GeoNamesWeatherService (
    private val client: HttpClient=createHttpClient()
){
    suspend fun getNearWeather(
        latitude: Double,
        longitude: Double,
        username: String = "sekharonline4u"
    ): WeatherObservation {
        println("Lat: $latitude")
        println("Lon: $longitude")
        println("user: $username")
        val response:  WeatherApiResponse=client.get("http://api.geonames.org/findNearByWeatherJSON"){
            parameter("formatted", "true")
            parameter("lat", latitude)
            parameter("lng", longitude)
            parameter("username", username)
            parameter("style", "full")
        }.body()

        println("API Response: ${response.weatherObservation}")
        println("API Response Status :: ${response.status}")
        return response.weatherObservation ?: throw IllegalStateException("No Weather Observation Found in API Response")
    }
}