package com.example.net.ui.graphs

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Settings
import androidx.compose.ui.graphics.vector.ImageVector
import com.example.net.utils.Constants.Companion.CALCULATE_SCREEN
import com.example.net.utils.Constants.Companion.DEVICES_SCREEN
import com.example.net.utils.Constants.Companion.PROFILE_SCREEN

sealed class CalcScreens(
    val route: String,
    val title: String,
    val icon: ImageVector,
) {
    object Calculate : CalcScreens(CALCULATE_SCREEN, "Calculate", Icons.Default.Edit)
    object Devices : CalcScreens(DEVICES_SCREEN, "Devices", Icons.Default.Settings)
    object Profile : CalcScreens(PROFILE_SCREEN, "Profile", Icons.Default.Person)

}
