package com.example.pratica_jp

import android.app.Activity
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.LocalActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.example.pratica_jp.model.MainViewModel
import com.example.pratica_jp.ui.theme.Pratica_jpTheme

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
fun MapPage(modifier: Modifier = Modifier.Companion, viewModel: MainViewModel) {
    val activity = LocalActivity.current as Activity

    Column(
        modifier = modifier.fillMaxSize()
            .background(Color.Gray)
            .wrapContentSize(Alignment.Center)
    ) {
        Text(text = "Mapa",
            fontWeight = FontWeight.Bold,
            color = Color.White,
            modifier = modifier.align(CenterHorizontally),
            textAlign = TextAlign.Center,
            fontSize = 20.sp)

        Button(onClick = {
            activity.finish()
        }) {
            Text("Sair")
        }
    }
}