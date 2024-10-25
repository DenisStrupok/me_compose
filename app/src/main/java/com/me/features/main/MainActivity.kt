package com.me.features.main

import android.graphics.Color
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.me.features.home.HomeScreen
import com.me.features.splash.SplashScreen
import com.me.features.weather.WeatherScreen
import com.me.routes.Routes.ROUTE_HOME_SCREEN
import com.me.routes.Routes.ROUTE_SPLASH_SCREEN
import com.me.routes.Routes.ROUTE_WEAHTER_SCREEN
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val navController = rememberNavController()
            window.apply {
                this.statusBarColor = Color.BLACK
                this.navigationBarColor = Color.BLACK
            }
            Surface(
                modifier = Modifier.fillMaxSize()
            ) {
                NavHost(navController = navController, startDestination = ROUTE_HOME_SCREEN) {
                    composable(ROUTE_SPLASH_SCREEN) {
                        SplashScreen()
                    }
                    composable(ROUTE_HOME_SCREEN) {
                        HomeScreen(
                            actionNavItemClick = { title ->
                                when (title) {
                                    "Weather" -> navController.navigate(ROUTE_WEAHTER_SCREEN)
                                }
                            }
                        )
                    }
                    composable(ROUTE_WEAHTER_SCREEN) {
                        WeatherScreen(
                            actionBack = {
                                navController.popBackStack()
                            }
                        )
                    }
                }
            }

        }
    }

}


