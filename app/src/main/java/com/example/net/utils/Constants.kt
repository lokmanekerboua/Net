package com.example.net.utils

import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import com.example.net.R

class Constants {
    companion object {
        //------------------------------------font poppins-------------------------------------------
        val fontfamily = FontFamily(
            Font(R.font.poppins_regular, FontWeight.Normal),
            Font(R.font.poppins_bold, FontWeight.Bold),
            Font(R.font.poppins_extrabold, FontWeight.ExtraBold),
            Font(R.font.poppins_extralight, FontWeight.ExtraLight),
            Font(R.font.poppins_medium, FontWeight.Medium),
            Font(R.font.poppins_light, FontWeight.Light),
        )

        //------------------------------------------screens const-----------------------------------------------
        const val SPLASH_SCREEN: String = "splash"
        const val LOGIN_SCREEN: String = "login"
        const val SIGNUP_SCREEN: String = "signup"
        const val HOME_SCREEN: String = "home"
        const val DEVICES_SCREEN: String = "devices"
        const val PANE_SCREEN: String = "pane"
        const val CALCULATE_SCREEN: String = "calculate"
        const val ADD_NEW_DEP_SCREEN: String = "newdep"
        const val ADD_NEW_NET_DEVICE_SCREEN: String = "newnetdevice"
        const val PROFILE_SCREEN: String = "profile"
        const val IPV4_SCREEN: String = "ipv4"
        const val BIN2DEC_SCREEN: String = "bin2dec"
        const val BIN2HEX_SCREEN: String = "bin2hex"
        const val NET_DEVICES_SCREEN: String = "netdevices"
        const val AUTH_NAV_GRAPH: String = "authgraph"
        const val ROOT_NAV_GRAPH: String = "rootgraph"
        const val HOME_NAV_GRAPH: String = "homegraph"

        //------------------------------------------API data-------------------------------------------------------
        const val BASE_URL = "http://10.0.0.2:3300/"
        const val USERS_URL = "users"
        const val DIRECTIONS_URL = "directions"
        const val DEL_DIRECTIONS_URL = "directions/"
        const val DIRECTIONS_DEVICES_URL = "devices/"
        const val DELETE_DEVICE_DEP = "devices"
        const val PANE_DEVICES_URL = "panedevices"
        const val ADD_NEW_DEVICES_URL = "addnewHote"
        const val NET_DEVICES_URL = "netdevices"
    }
}