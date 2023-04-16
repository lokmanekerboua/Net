package com.example.net.ui.graphs

import com.example.net.utils.Constants.Companion.ADD_NEW_DEP_SCREEN
import com.example.net.utils.Constants.Companion.ADD_NEW_NET_DEVICE_SCREEN
import com.example.net.utils.Constants.Companion.BIN2DEC_SCREEN
import com.example.net.utils.Constants.Companion.BIN2HEX_SCREEN
import com.example.net.utils.Constants.Companion.HOME_SCREEN
import com.example.net.utils.Constants.Companion.IPV4_SCREEN
import com.example.net.utils.Constants.Companion.LOGIN_SCREEN
import com.example.net.utils.Constants.Companion.NET_DEVICES_SCREEN
import com.example.net.utils.Constants.Companion.SIGNUP_SCREEN
import com.example.net.utils.Constants.Companion.SPLASH_SCREEN

sealed class Screens(val route: String) {
    object SplashScreen : Screens(SPLASH_SCREEN)
    object LoginScreen : Screens(LOGIN_SCREEN)
    object SignupScreen : Screens(SIGNUP_SCREEN)

    object DevicesShow : Screens(route = "devicesShow?department={department}") {
        fun passDepartement(department: String): String {
            return "devicesShow?department=${department}"
        }
    }

    object NetDevices : Screens(route = NET_DEVICES_SCREEN)

    object AddnewDepScreen : Screens(route = ADD_NEW_DEP_SCREEN)

    object AddnewDevice : Screens(route = "addnewdevices?department={department}") {
        fun passDepartement(department: String): String {
            return "addnewdevices?department=${department}"
        }
    }

    object AddnewNetDevice : Screens(ADD_NEW_NET_DEVICE_SCREEN)

    object HomeScreen : Screens(HOME_SCREEN)
    object Ipv4Screen : Screens(IPV4_SCREEN)
    object Bin2decScreen : Screens(BIN2DEC_SCREEN)
    object Bin2hexScreen : Screens(BIN2HEX_SCREEN)
}
