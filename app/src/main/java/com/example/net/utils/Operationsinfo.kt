package com.example.net.utils

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Settings
import com.example.net.data.model.Operationinfo
import com.example.net.R
import com.example.net.ui.graphs.Screens

val operations = listOf(
    Operationinfo(
        "IPV4",
        "Generate ipv4 address information",
        R.drawable.ip,
        Screens.Ipv4Screen.route
    ),
    Operationinfo(
        "BINTODEC",
        "convert binary to decimal and revers",
        R.drawable.binarycode,
        Screens.Bin2decScreen.route
    ),
    Operationinfo(
        "BINTOHEX",
        "convert binary to hexadecimal and revert",
        R.drawable.binarycode,
        Screens.Bin2hexScreen.route
    )
)