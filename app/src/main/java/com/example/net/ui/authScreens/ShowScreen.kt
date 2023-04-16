package com.example.net.ui.authScreens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.example.net.R
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun ShowScreen() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(color = colorResource(id = R.color.greenShow)),
        contentAlignment = Alignment.Center
    ) {
        Text(text = "Your Company in one Hand")
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun ShowScreenPreview() {
    ShowScreen()
}