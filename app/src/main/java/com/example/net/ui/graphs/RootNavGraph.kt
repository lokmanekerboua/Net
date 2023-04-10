package com.example.net.ui.graphs

import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.net.ui.authScreens.AnimatedSplashScreen
import com.example.net.ui.homeScreens.HomeScreen
import com.example.net.utils.Constants.Companion.AUTH_NAV_GRAPH
import com.example.net.utils.Constants.Companion.ROOT_NAV_GRAPH
import com.example.net.utils.Constants.Companion.SPLASH_SCREEN

@Composable
fun RootNavigationGraph(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = SPLASH_SCREEN,
        route = ROOT_NAV_GRAPH
    ) {

        composable(route = Screens.SplashScreen.route) {
            AnimatedSplashScreen(navController)
        }

        AuthNavGraph(navController)

        composable(route = Screens.HomeScreen.route) {
            HomeScreen()
        }
    }
}