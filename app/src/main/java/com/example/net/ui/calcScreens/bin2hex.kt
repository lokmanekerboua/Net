package com.example.net.ui.calcScreens

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.net.R
import com.example.net.ui.graphs.CalcScreens
import com.example.net.utils.Constants

@Composable
fun bin2hex(navController: NavController) {
    Box(modifier = Modifier.fillMaxSize()) {
        Row(
            modifier = Modifier
                .fillMaxSize()
                .padding(start = 15.dp, top = 0.dp, end = 15.dp, bottom = 0.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                painter = painterResource(id = R.drawable.net1),
                contentDescription = null,
                modifier = Modifier
                    .size(24.dp)
            )
            Text(
                text = "BIN TO HEX", fontWeight = FontWeight.Bold,
                fontFamily = Constants.fontfamily,
                fontSize = 18.sp,
                textAlign = TextAlign.Start,
            )
            Icon(
                imageVector = Icons.Default.ArrowBack,
                contentDescription = null,
                modifier = Modifier.clickable {
                    navController.popBackStack()
                })
        }
    }
}