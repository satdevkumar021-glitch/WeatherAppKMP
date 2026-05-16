package com.sokhal.weatherapp

sealed class WeatherUiState {
    data object Idle: WeatherUiState()
    data object Loading: WeatherUiState()
    data class Success(val weather: WeatherObservation): WeatherUiState()
    data class Error(val message:String): WeatherUiState()
}