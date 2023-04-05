package com.example.net.ui.graphs

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.example.net.ui.authScreens.Login
import com.example.net.ui.authScreens.Signup
import com.example.net.utils.Constants.Companion.AUTH_NAV_GRAPH
import com.example.net.utils.Constants.Companion.ROOT_NAV_GRAPH


fun NavGraphBuilder.AuthNavGraph(navController: NavController) {
    navigation(startDestination = Screens.LoginScreen.route, route = AUTH_NAV_GRAPH) {
        composable(route = Screens.LoginScreen.route) {
            Login(navController)
        }

        composable(route = Screens.SignupScreen.route) {
            Signup(navController)
        }
    }
}