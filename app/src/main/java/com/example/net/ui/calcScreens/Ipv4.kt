package com.example.net.ui.calcScreens

import androidx.compose.foundation.clickable
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.example.net.ui.graphs.CalcScreens

@Composable
fun Ipv4(navController: NavController) {
    Text(text = "Return", modifier = Modifier.clickable {
        navController.popBackStack()
        //navController.navigate(CalcScreens.Calculate.route)
    })
}