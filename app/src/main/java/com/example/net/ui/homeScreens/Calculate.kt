package com.example.net.ui.homeScreens

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.net.model.Operationinfo
import com.example.net.utils.operations

@Composable
fun Calcule(navController: NavController) {


    Column(modifier = Modifier.fillMaxSize()) {

        LazyVerticalGrid(
            columns = GridCells.Fixed(1),
            contentPadding = PaddingValues(vertical = 12.dp, horizontal = 12.dp),
            content = {
                items(operations) { operation ->
                    CardCard(operation = operation,navController)
                }
            })
    }
}

@Composable
fun CardCard(operation : Operationinfo, navController: NavController) {
    Card(
        elevation = 5.dp,
        shape = RoundedCornerShape(5.dp),
        modifier = Modifier
            .padding(top = 5.dp, bottom = 5.dp, start = 10.dp, end = 10.dp)
            .fillMaxSize()
            .clickable {

            }
    ) {
        Column {
            Image(
                imageVector = operation.icon , contentDescription = null, contentScale = ContentScale.Fit,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(50.dp)
            )


            Column(modifier = Modifier.padding(10.dp)) {
                Text(
                    text = operation.name,
                    fontWeight = FontWeight.Bold,
                    fontSize = 18.sp,
                    textAlign = TextAlign.Start,
                    modifier = Modifier.align(Alignment.Start),
                )
                Text(
                    text = operation.description,
                    fontWeight = FontWeight.Normal,
                    modifier = Modifier.align(Alignment.Start),
                    textAlign = TextAlign.Start
                )
            }
        }
    }
}


@Preview(showSystemUi = true, showBackground = true)
@Composable
fun show (){
    Calcule(navController = rememberNavController())
}