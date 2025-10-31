package com.example.pratica_jp.ui.nav

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.example.pratica_jp.ui.nav.ui.theme.Pratica_jpTheme

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
fun BottomNavBar(navController: NavHostController, items : List<BottomNavItem>) {
    NavigationBar(
        contentColor = Color.Black
    ) {
        val navBackStackEntry by navController.currentBackStackEntryAsState()
        val currentRoute = navBackStackEntry?.destination
        items.forEach { item ->
            NavigationBarItem(
                icon = { Icon(imageVector = item.icon, contentDescription = item.title) },

                label = { Text(text = item.title, fontSize = 12.sp) },

                alwaysShowLabel = true,

                selected = currentRoute == item.route,

                onClick = {
                    navController.navigate(item.route) {
// Volta pilha de navegação até HomePage (startDest).
                        navController.graph.startDestinationRoute?.let {

                            popUpTo(it) {
                                saveState = true
                            }

                            restoreState = true

                        }

                        launchSingleTop = true

                    }
                }
            )
        }
    }
}