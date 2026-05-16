package com.sokhal.weatherapp
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
@Serializable
data class WeatherApiResponse(
    val weatherObservation : WeatherObservation? = null
)
@Serializable
data class WeatherObservation(
    val elevation:Int? = null,
    val lng:Double? = null,
    val observation : String? =null ,
    @SerialName("ICAO")
    val icao : String? = null,
    val clouds: String? = null,
    val dewPoint : String? = null,
    val cloudsCode : String? = null ,
    val datetime: String? = null,
    val countryCode: String? = null,
    val temperature : String? = null,
    val humidity: Int? = null,
    val stationName : String? = null,
    val weatherCondition : String? = null,
    val windDirection: Int? = null,
    val hectoPascAltimeter: Int? = null,
    val windSpeed: String? = null,
    val lat: Double? = null
)