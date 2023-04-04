package com.example.net.ui.graphs

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.ui.graphics.vector.ImageVector
import com.example.net.utils.Constants.Companion.CALCULATE_SCREEN
import com.example.net.utils.Constants.Companion.DEVICES_SCREEN
import com.example.net.utils.Constants.Companion.PROFILE_SCREEN

sealed class CalcScreens(
    val route: String,
    val title: String,
    val icon: ImageVector,
) {
    object Calculate : CalcScreens(CALCULATE_SCREEN, "Calculate", Icons.Default.Menu)
    object Devices : CalcScreens(DEVICES_SCREEN, "Calculate", Icons.Default.Menu)
    object Profile : CalcScreens(PROFILE_SCREEN, "Calculate", Icons.Default.Menu)

}
