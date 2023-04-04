package com.example.net.ui.graphs

import com.example.net.utils.Constants.Companion.BIN2DEC_SCREEN
import com.example.net.utils.Constants.Companion.BIN2HEX_SCREEN
import com.example.net.utils.Constants.Companion.HOME_SCREEN
import com.example.net.utils.Constants.Companion.IPV4_SCREEN
import com.example.net.utils.Constants.Companion.LOGIN_SCREEN
import com.example.net.utils.Constants.Companion.SIGNUP_SCREEN

sealed class Screens(val route: String) {
    object LoginScreen : Screens(LOGIN_SCREEN)
    object SignupScreen : Screens(SIGNUP_SCREEN)

    object HomeScreen : Screens(HOME_SCREEN)
    object Ipv4Screen : Screens(IPV4_SCREEN)
    object Bin2decScreen : Screens(BIN2DEC_SCREEN)
    object Bin2hexScreen : Screens(BIN2HEX_SCREEN)
}
