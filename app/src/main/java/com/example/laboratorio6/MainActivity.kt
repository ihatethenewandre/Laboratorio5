package com.example.laboratorio6

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Star
import androidx.compose.material.icons.rounded.Menu
import androidx.compose.material3.Divider
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.NavigationDrawerItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.laboratorio6.ui.theme.Amarillo
import com.example.laboratorio6.ui.theme.Laboratorio6Theme
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Laboratorio6Theme {
                Surface (
                    color = MaterialTheme.colorScheme.background
                ) {
                    NavigationDrawer()
                }
            }
        }
    }
}

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NavigationDrawer() {
    val navigationController = rememberNavController()
    val coroutineScope = rememberCoroutineScope()
    val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
    val context = LocalContext.current.applicationContext

    ModalNavigationDrawer(
        drawerState = drawerState,
        gesturesEnabled = true,
        drawerContent = {
            ModalDrawerSheet {
                Column {
                    Box(modifier = Modifier
                        .background(Amarillo)
                        .fillMaxWidth()
                        .height(151.dp)
                    ) { Text(text = "") }
                    Divider()
                    NavigationDrawerItem(label = { Text(text = "Pantalla #1", color = Color.Black)},
                        selected = false,
                        icon = { Icon(imageVector = Icons.Default.Star, contentDescription = "", tint = Amarillo)},
                        onClick = {
                            coroutineScope.launch {
                                drawerState.close()
                            }
                            navigationController.navigate(Menu.P1.screen) {
                                popUpTo(0)
                            }
                        }
                    )
                    NavigationDrawerItem(label = { Text(text = "Pantalla #3", color = Color.Black)},
                        selected = false,
                        icon = { Icon(imageVector = Icons.Default.Star, contentDescription = "", tint = Amarillo)},
                        onClick = {
                            coroutineScope.launch {
                                drawerState.close()
                            }
                            navigationController.navigate(Menu.P3.screen) {
                                popUpTo(0)
                            }
                        }
                    )
                    NavigationDrawerItem(label = { Text(text = "Pantalla #4", color = Color.Black)},
                        selected = false,
                        icon = { Icon(imageVector = Icons.Default.Star, contentDescription = "", tint = Amarillo)},
                        onClick = {
                            coroutineScope.launch {
                                drawerState.close()
                            }
                            navigationController.navigate(Menu.P4.screen) {
                                popUpTo(0)
                            }
                        }
                    )
                }
            }
        }
    ) {
        Scaffold(
            topBar = {
                val coroutineScope = rememberCoroutineScope()
                TopAppBar(title = { Text(text = "Laboratorio #6") },
                    colors = TopAppBarDefaults.topAppBarColors(
                        containerColor = Amarillo,
                        titleContentColor = Color.White,
                        navigationIconContentColor = Color.Black
                    ),
                    navigationIcon = {
                        IconButton(onClick = {
                            coroutineScope.launch {
                                drawerState.open()
                            }
                        }) {
                            Icon(
                                Icons.Rounded.Menu, contentDescription = ""
                            )
                        }
                    })
            }
        ) {
            NavHost(navController = navigationController,
                startDestination = Menu.P1.screen) {
                composable(Menu.P1.screen) { Pantalla1(navController = navigationController) }
                composable(route = "Pantalla2/{eventTitle}", arguments = listOf(navArgument("eventTitle") { type = NavType.StringType })) {
                    backStackEntry ->
                    val eventTitle = backStackEntry.arguments?.getString("eventTitle")
                    Pantalla2(navController = navigationController, eventTitle = eventTitle ?: "Sin Titulo")
                }
                composable(Menu.P3.screen) { Pantalla3() }
                composable(Menu.P4.screen) { Pantalla4() }
            }
        }
    }
}