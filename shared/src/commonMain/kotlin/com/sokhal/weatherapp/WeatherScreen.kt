package com.sokhal.weatherapp

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.launch

@Composable
fun AndroidWeatherScreen(){
    val controller = remember { WeatherController() }
    val state by controller.state.collectAsState()
    val scope = rememberCoroutineScope()

    var latitudeText by remember { mutableStateOf("42.0") }
    var longitudeText by remember { mutableStateOf("-2.0")}

    WeatherContent(
        title = "GeoName Weather - Multiplatform",
        latitudeText = latitudeText,
        longitudeText = longitudeText,
        onLatitudeChange = { latitudeText = it },
        onLongitudeText = { longitudeText = it },
        state = state,
        onFetchClick = {
            val latitude = latitudeText.toDoubleOrNull()
            val longitude = longitudeText.toDoubleOrNull()
            if (latitude != null && longitude != null) {
                scope.launch {
                    controller.loadWeather(latitude, longitude)
                }
            }
        }
    )
}

@Composable
private fun WeatherContent(
    title: String,
    latitudeText: String,
    longitudeText: String,
    onLatitudeChange: (String) -> Unit,
    onLongitudeText: (String) -> Unit,
    state: WeatherUiState,
    onFetchClick: () -> Unit
) {
    Column(
        modifier = Modifier.fillMaxSize().padding(24.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(title)
        Spacer(modifier = Modifier.height(16.dp))
        OutlinedTextField(
            value = latitudeText,
            onValueChange = onLatitudeChange,
            label = { Text("Latitude") },
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(16.dp))
        OutlinedTextField(
            value = longitudeText,
            onValueChange = onLongitudeText,
            label = { Text("Longitude") },
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(16.dp))
        Button(onFetchClick) {
            Text("Get Weather")
        }
        Spacer(modifier = Modifier.height(16.dp))

        when (state) {
            is WeatherUiState.Error -> Text("Error: ${state.message}")
            WeatherUiState.Idle -> Text("Enter Latitude and Longitude, then tap Get Weather")
            WeatherUiState.Loading -> CircularProgressIndicator()
            is WeatherUiState.Success -> WeatherCard(state.weather)
        }
    }
}

@Composable
private fun WeatherCard(weather: WeatherObservation) {
    Card {
        Column(
            modifier = Modifier.padding(20.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            Text("Station : ${weather.stationName ?: "-"}")
            Text("Country : ${weather.countryCode ?: "-"}")
            Text("Temperature : ${weather.temperature ?: "-"}")
            Text("Humidity : ${weather.humidity ?: "-"}%")
            Text("Wind Direction : ${weather.windDirection ?: "-"}")
            Text("Date Time : ${weather.datetime ?: "-"}")
            Text("Observation : ${weather.observation ?: "-"}")
        }
    }
}