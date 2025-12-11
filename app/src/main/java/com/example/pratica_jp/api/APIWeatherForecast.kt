package com.example.pratica_jp.api

data class APIWeatherForecast (
    var location: APILocation? = null,
    var current: APIWeatherForecast? = null,
    var forecast: APIForecast? = null
)

