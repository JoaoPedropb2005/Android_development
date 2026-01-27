package com.example.pratica_jp.model

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.pratica_jp.api.WeatherService
import com.example.pratica_jp.db.fb.FBDatabase
import com.example.pratica_jp.monitor.ForecastMonitor


class MainViewModelFactory(private val db: FBDatabase,
                            private val service : WeatherService,
                           private val monitor: ForecastMonitor
) :
    ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(MainViewModel::class.java)) {
            return MainViewModel(db, service, monitor) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}
