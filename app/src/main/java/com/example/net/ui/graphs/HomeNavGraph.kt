package com.example.net.ui.graphs

import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.net.ui.calcScreens.Ipv4
import com.example.net.ui.calcScreens.bin2dec
import com.example.net.ui.calcScreens.bin2hex
import com.example.net.ui.homeScreens.Calculate
import com.example.net.ui.homeScreens.Devices
import com.example.net.ui.homeScreens.Profile
import com.example.net.utils.Constants.Companion.HOME_NAV_GRAPH

@Composable
fun HomeNavGraph(navController: NavHostController) {
    NavHost(navController = navController, startDestination = CalcScreens.Devices.route , route = HOME_NAV_GRAPH) {
        composable(route = CalcScreens.Devices.route) {
            Devices(navController)
        }

        composable(route = CalcScreens.Profile.route) {
            Profile()
        }

        composable(route = CalcScreens.Calculate.route) {
            Calculate(navController = navController)
        }
        
        composable(route = Screens.Ipv4Screen.route){
            Ipv4(navController = navController)
        }
        
        composable(route = Screens.Bin2decScreen.route){
            bin2dec(navController = navController)
        }
        
        composable(route = Screens.Bin2hexScreen.route){
            bin2hex(navController = navController)
        }
    }
}