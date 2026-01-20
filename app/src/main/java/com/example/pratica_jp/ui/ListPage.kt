package com.example.pratica_jp.ui

import android.app.Activity
import android.widget.Toast
import androidx.activity.compose.LocalActivity
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.rounded.FavoriteBorder
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.example.pratica_jp.R
import com.example.pratica_jp.model.City
import com.example.pratica_jp.model.MainViewModel
import com.example.pratica_jp.model.Weather
import com.example.pratica_jp.ui.nav.Route

//class ListPage : ComponentActivity() {
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        enableEdgeToEdge()
//        setContent {
//            Pratica_jpTheme {
//                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
//                    ListPage(
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
fun ListPage(modifier: Modifier = Modifier.Companion, viewModel: MainViewModel) {
    val activity = LocalActivity.current as Activity
    val cityList = viewModel.cities

    LazyColumn(
        modifier = modifier
            .fillMaxSize()
            .padding(8.dp)
    )
     {
        items(cityList, key = {it.name}){ city ->
            CityItem(city = city, weather = viewModel.weather(city.name), onClick = {
                viewModel.city = city.name
                viewModel.page = Route.Home
                Toast.makeText(activity, "${city.name} Selecionada", Toast.LENGTH_LONG).show()
            }, onClose = {
                viewModel.remove(city)
                Toast.makeText(activity, "${city.name} Excluido", Toast.LENGTH_LONG).show()
            })
        }
//        items(items = cityList, key = { it.name } ) { city ->
//            CityItem(city = city, /* weather = viewModel.weather(city.name),*/ onClick = {
//                viewModel.city = city.name
//                Toast.makeText(activity, "${city.name} Aberto", Toast.LENGTH_LONG).show()
//            },onClose = {
//                viewModel.remove(city)
//                Toast.makeText(activity, "${city.name} Excluido", Toast.LENGTH_LONG).show()
//            })
//        }
    }

//    Column(
//        modifier = modifier.fillMaxSize()
//            .background(Color.Magenta)
//            .wrapContentSize(Alignment.Center)
//    ) {
//        Text(text = "Favoritas",
//            fontWeight = FontWeight.Bold,
//            color = Color.White,
//            modifier = modifier.align(CenterHorizontally),
//            textAlign = TextAlign.Center,
//            fontSize = 20.sp)
//
//        Button(onClick = {
//            activity.finish()
//        }) {
//            Text("Sair")
//        }
//    }
}

@Composable
fun CityItem(
    city: City,
    weather: Weather,
    onClick: () -> Unit,
    onClose: () -> Unit,
    modifier: Modifier = Modifier
) {
    val desc = if (weather == Weather.LOADING) "Carregando clima..." else weather.desc
    Row(
        modifier = modifier.fillMaxWidth().padding(8.dp).clickable { onClick() },
        verticalAlignment = Alignment.CenterVertically
    ) {
        AsyncImage( // Substitui o Icon(...)
            model = weather.imgUrl,
            modifier = Modifier.size(75.dp),
            error = painterResource(id = R.drawable.loading),
            contentDescription = "Imagem"
        )
        Spacer(modifier = Modifier.size(12.dp))
        Column(modifier = modifier.weight(1f)) {
            Text(modifier = Modifier,
                text = city.name,
                fontSize = 24.sp)
            Text(modifier = Modifier,
                text = desc,
                fontSize = 16.sp)

        }
        IconButton(onClick = onClose) {
            Icon(Icons.Filled.Close, contentDescription = "Close")
        }
    }
}