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
        const val CALCULATE_SCREEN: String = "calculate"
        const val PROFILE_SCREEN: String = "profile"
        const val IPV4_SCREEN: String = "ipv4"
        const val BIN2DEC_SCREEN: String = "bin2dec"
        const val BIN2HEX_SCREEN: String = "bin2hex"
        const val AUTH_NAV_GRAPH: String = "authgraph"
        const val ROOT_NAV_GRAPH: String = "rootgraph"
        const val HOME_NAV_GRAPH: String = "homegraph"

        //------------------------------------------API data-------------------------------------------------------
        const val BASE_URL = "http://10.0.0.2:3300/"
        const val USERS_URL = "users"
    }
}