package com.example.net.utils

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Settings
import com.example.net.model.Operationinfo

val operations = listOf(
    Operationinfo(
        "IPV4",
        "Generate ipv4 address information",
        Icons.Default.Settings
    ),
    Operationinfo(
        "BINTODEC",
        "convert binary to decimal and revers",
        Icons.Default.Settings
    ),
    Operationinfo(
        "BINTOHEX",
        "convert binary to hexadecimal and revert",
        Icons.Default.Settings
    )
)