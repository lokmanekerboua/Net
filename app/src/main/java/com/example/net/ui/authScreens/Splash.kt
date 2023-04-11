package com.example.net.ui.authScreens

import android.content.Context
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material.Icon
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import com.example.net.R
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.net.ui.graphs.Screens
import kotlinx.coroutines.delay

@Composable
fun AnimatedSplashScreen(navController: NavController) {
    var startanimation by remember {
        mutableStateOf(false)
    }

    var alphaAnim = animateFloatAsState(
        targetValue = if (startanimation) 1f else 0f,
        animationSpec = tween(durationMillis = 2000)
    )
    LaunchedEffect(key1 = true) {
        startanimation = true
        delay(3000)
        navController.popBackStack()
        navController.navigate(Screens.LoginScreen.route)
    }
    Splash(alphaAnim.value)
}

@Composable
fun Splash(alpha: Float) {
    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        Icon(
            modifier = Modifier
                .size(120.dp)
                .alpha(alpha),
            painter = painterResource(id = R.drawable.net1),
            contentDescription = null,
            tint = colorResource(id = R.color.green)
        )
    }
}
