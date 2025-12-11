package com.example.pratica_jp.api

import com.example.pratica_jp.model.Forecast

data class APIForecastDay ( var date: String? = null, var day: APIWeather? = null )

fun APIWeatherForecast.toForecast(): List<Forecast>? {
    return forecast?.forecastday?.map {
        Forecast(
            date = it.date?:"00-00-0000",
            weather = it.day?.condition?.text?:"Erro carregando!",
            tempMin = it.day?.mintemp_c?:-1.0,
            tempMax = it.day?.maxtemp_c?:-1.0,
            imgUrl = ("https:" + it.day?.condition?.icon)
        )
    }
}
