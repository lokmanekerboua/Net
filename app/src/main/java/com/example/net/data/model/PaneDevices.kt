package com.example.net.data.model

data class PaneDevices(
    val name: String,
    val type: String,
    val bloc: String,
    val floor: Int,
    var description: String,
    val degree: String
)

data class PaneDelete(
    val name: String,
    val type: String,
    val bloc: String,
    val floor: Int
)
