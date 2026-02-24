package com.example.pratica_jp.ui

import android.Manifest
import android.app.Activity
import android.content.pm.PackageManager
import androidx.activity.compose.LocalActivity
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.core.content.ContextCompat
import androidx.core.content.ContextCompat.getDrawable
import androidx.core.graphics.drawable.toBitmap
import androidx.core.graphics.scale
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.example.pratica_jp.R
import com.example.pratica_jp.model.MainViewModel
import com.example.pratica_jp.model.Weather
import com.google.android.gms.maps.model.BitmapDescriptorFactory
import com.google.android.gms.maps.model.LatLng
import com.google.maps.android.compose.GoogleMap
import com.google.maps.android.compose.MapProperties
import com.google.maps.android.compose.MapUiSettings
import com.google.maps.android.compose.Marker
import com.google.maps.android.compose.MarkerState
import com.google.maps.android.compose.rememberCameraPositionState

//class MapPage : ComponentActivity() {
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        enableEdgeToEdge()
//        setContent {
//            Pratica_jpTheme {
//                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
//                    MapPage(
//                        modifier = Modifier.padding(innerPadding)
//                    )
//                }
//            }
//        }
//    }
//}

//@Composable
//fun Greeting(name: String, modifier: Modifier = Modifier) {
//    Text(
//        text = "Hello $name!",
//        modifier = modifier
//    )
//}
//
//@Preview(showBackground = true)
//@Composable
//fun GreetingPreview() {
//    Pratica_jpTheme {
//        Greeting("Android")
//    }
//}


@Composable
fun MapPage(viewModel: MainViewModel) {

    val camPosState = rememberCameraPositionState ()

    val context = LocalContext.current

    val cities by viewModel.cities.collectAsStateWithLifecycle(initialValue = emptyMap())
    val weathers by viewModel.weather.collectAsStateWithLifecycle(initialValue = emptyMap())

    val hasLocationPermission by remember {
        mutableStateOf(
            ContextCompat.checkSelfPermission(context,
                Manifest.permission.ACCESS_FINE_LOCATION) ==
                    PackageManager.PERMISSION_GRANTED
        )
    }



    GoogleMap (modifier = Modifier.fillMaxSize(), cameraPositionState = camPosState, onMapClick = {viewModel.addCity(it) }, properties = MapProperties(
        isMyLocationEnabled = hasLocationPermission
    ),
        uiSettings = MapUiSettings(myLocationButtonEnabled = true)
    )
    {

        cities.values.forEach { city ->
            if (city.location != null) {
                val weather = weathers[city.name] ?: Weather.LOADING

                LaunchedEffect(city.name) {
                    viewModel.loadWeather(city.name)
                }
                LaunchedEffect(weather.imgUrl) { // Dispara quando a URL da imagem estiver disponível
                    viewModel.loadBitmap(city.name)
                }


                // Define o ícone (Bitmap)
                val image = weather.bitmap ?:
                getDrawable(context, R.drawable.loading)!!.toBitmap()

                val markerIcon = remember(image) {
                    BitmapDescriptorFactory.fromBitmap(image.scale(120, 120))
                }

                val desc = if (weather == Weather.LOADING) "Carregando clima..."
                else weather.desc

                Marker(
                    state = MarkerState(position = city.location),
                    icon = markerIcon,
                    title = city.name,
                    snippet = desc
                )
            }
        }
    }
}