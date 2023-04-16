package com.example.net.data.model

import androidx.compose.ui.graphics.vector.ImageVector

data class Directions(
    val Icon: ImageVector,
    val name: String,
    val description: String
)

data class Direction(
    val name: String,
    val description: String
)
