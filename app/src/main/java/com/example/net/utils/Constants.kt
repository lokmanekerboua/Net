package com.example.net.utils

import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import com.example.net.R

class Constants {
    companion object {
        val fontfamily = FontFamily(
            Font(R.font.poppins_regular, FontWeight.Normal),
            Font(R.font.poppins_bold, FontWeight.Bold),
            Font(R.font.poppins_extrabold, FontWeight.ExtraBold),
            Font(R.font.poppins_extralight, FontWeight.ExtraLight),
            Font(R.font.poppins_medium, FontWeight.Medium),
            Font(R.font.poppins_light, FontWeight.Light),
        )

        val LOGIN_SCREEN: String = "login"
        val SIGNUP_SCREEN: String = "signup"
        val HOME_SCREEN: String = "home"
        val DEVICES_SCREEN: String = "devices"
        val CALCULATE_SCREEN: String = "calculate"
        val PROFILE_SCREEN: String = "profile"
        val IPV4_SCREEN: String = "ipv4"
        val BIN2DEC_SCREEN: String = "bin2dec"
        val BIN2HEX_SCREEN: String = "bin2hex"

        val AUTH_NAV_GRAPH : String = "authgraph"
        val ROOT_NAV_GRAPH : String = "rootgraph"
        val HOME_NAV_GRAPH : String = "homegraph"
    }
}