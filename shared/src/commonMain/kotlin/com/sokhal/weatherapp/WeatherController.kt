package com.sokhal.weatherapp

import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class WeatherController(
    private val service: GeoNamesWeatherService=
        GeoNamesWeatherService()
) {
    private val _state= MutableStateFlow<WeatherUiState>(WeatherUiState.Idle)
    val state: StateFlow<WeatherUiState> = _state.asStateFlow()

    suspend fun loadWeather(latitude: Double,longitude: Double){
        _state.value= WeatherUiState.Loading
        try {
            val weather=service.getNearWeather(latitude,longitude)
            _state.value = WeatherUiState.Success(weather)
        }
        catch (e: Exception){
            _state.value = WeatherUiState.Error(e.message ?: "Unable to load weather report")
        }
    }
}