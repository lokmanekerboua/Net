package com.example.net.ui.homeScreens

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.net.R
import com.example.net.data.model.Operationinfo
import com.example.net.utils.Constants
import com.example.net.utils.Constants.Companion.fontfamily
import com.example.net.utils.operations

@Composable
fun Calculate(navController: NavController) {


    Column(modifier = Modifier.fillMaxSize()) {

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(60.dp),
            contentAlignment = Alignment.Center,
        ) {
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
                    text = "Calculator", fontWeight = FontWeight.Bold,
                    fontFamily = Constants.fontfamily,
                    fontSize = 18.sp,
                    textAlign = TextAlign.Start,
                )
                Icon(
                    imageVector = Icons.Default.Add,
                    contentDescription = null,
                    modifier = Modifier.clickable {

                    })
            }
        }
        LazyVerticalGrid(
            columns = GridCells.Fixed(1),
            contentPadding = PaddingValues(vertical = 12.dp, horizontal = 12.dp),
            content = {
                items(operations) { operation ->
                    CardCard(operation = operation, navController)
                }
            })
    }
}

@Composable
fun CardCard(operation: Operationinfo, navController: NavController) {
    Card(
        elevation = 5.dp,
        shape = RoundedCornerShape(5.dp),
        modifier = Modifier
            .padding(top = 5.dp, bottom = 5.dp, start = 10.dp, end = 10.dp)
            .fillMaxSize()
            .clickable {
                navController.navigate(operation.route)
            }
    ) {
        Column {
            Image(
                painter = painterResource(id = operation.icon),
                contentDescription = null,
                contentScale = ContentScale.Fit,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(50.dp)
                    .padding(top = 10.dp)
            )


            Column(modifier = Modifier.padding(10.dp)) {
                Text(
                    text = operation.name,
                    fontWeight = FontWeight.Bold,
                    fontFamily = fontfamily,
                    fontSize = 18.sp,
                    textAlign = TextAlign.Start,
                    modifier = Modifier.align(Alignment.Start),
                )
                Text(
                    text = operation.description,
                    fontWeight = FontWeight.Normal,
                    fontFamily = fontfamily,
                    modifier = Modifier.align(Alignment.Start),
                    textAlign = TextAlign.Start
                )
            }
        }
    }
}


@Preview(showSystemUi = true, showBackground = true)
@Composable
fun show() {
    Calculate(navController = rememberNavController())
}