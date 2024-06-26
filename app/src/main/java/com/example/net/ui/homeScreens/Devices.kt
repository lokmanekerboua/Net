package com.example.net.ui.homeScreens

import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Card
import com.example.net.R
import androidx.compose.material.Divider
import androidx.compose.material.Icon
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.contentColorFor
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Settings
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.net.data.model.Direction
import com.example.net.data.model.NetDevices
import com.example.net.ui.graphs.Screens
import com.example.net.ui.homeScreens.devicesShow.DevicesViewModel
import com.example.net.utils.Constants
import com.example.net.utils.Resource

@Composable
fun Devices(navController: NavController) {

    val context = LocalContext.current
    val directionsViewModel: DirectionsViewModel = hiltViewModel()
    val devicesViewModel: DevicesViewModel = hiltViewModel()
    val directionFlow by directionsViewModel.getDirectionResponse.collectAsStateWithLifecycle()

    Box(contentAlignment = Alignment.Center, modifier = Modifier.fillMaxSize()) {
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
                        text = "All Company Devices", fontWeight = FontWeight.Bold,
                        fontFamily = Constants.fontfamily,
                        fontSize = 18.sp,
                        textAlign = TextAlign.Start,
                    )
                    Icon(
                        imageVector = Icons.Default.Add,
                        contentDescription = null,
                        modifier = Modifier.clickable {
                            navController.navigate(Screens.AddnewDepScreen.route)
                        })
                }
            }

            LazyVerticalGrid(
                columns = GridCells.Fixed(2),
                contentPadding = PaddingValues(vertical = 12.dp, horizontal = 12.dp),
                modifier = Modifier.padding(bottom = 70.dp)
            ) {
                item {
                    Card(
                        elevation = 5.dp,
                        shape = RoundedCornerShape(5.dp),
                        modifier = Modifier
                            .padding(top = 5.dp, bottom = 5.dp, start = 10.dp, end = 10.dp)
                            .fillMaxWidth()
                            .height(150.dp)
                            .clickable {
                                navController.navigate(Screens.NetDevices.route)
                            }
                    ) {
                        Column() {
                            Image(
                                painter = painterResource(id = R.drawable.network),
                                contentDescription = null,
                                contentScale = ContentScale.Fit,
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .height(50.dp)
                            )

                            Column(modifier = Modifier.padding(10.dp)) {
                                Text(
                                    text = "NET",
                                    fontWeight = FontWeight.Bold,
                                    fontFamily = Constants.fontfamily,
                                    fontSize = 18.sp,
                                    textAlign = TextAlign.Start,
                                    modifier = Modifier.align(Alignment.Start),
                                )
                                Text(
                                    text = "All intermediary equipment",
                                    fontWeight = FontWeight.Normal,
                                    fontFamily = Constants.fontfamily,
                                    modifier = Modifier.align(Alignment.Start),
                                    textAlign = TextAlign.Start,
                                    overflow = TextOverflow.Ellipsis
                                )
                            }

                        }
                    }
                }
                items(directionFlow) { direction ->
                    DevicesCard(
                        direction = direction,
                        navController,
                        directionsViewModel,
                        devicesViewModel
                    )
                }
            }
        }
    }


//    directionFlow?.value?.let {
//        when (it) {
//            is Resource.Success -> {
//                directions = it.data!!
//            }
//            is Resource.Error -> {
//                Toast.makeText(
//                    context,
//                    "error when get list of direction available",
//                    Toast.LENGTH_SHORT
//                ).show()
//            }
//            is Resource.Loading -> {}
//        }
//    }
}

@Composable
fun DevicesCard(
    direction: Direction,
    navController: NavController,
    showDepViewModel: DirectionsViewModel,
    delDepViewModel: DevicesViewModel
) {

    val showDialog = remember {
        mutableStateOf(false)
    }

    if (showDialog.value) {
        DeleteDepDialog(
            setShowDialog = { showDialog.value = it },
            delDepViewModel,
            showDepViewModel,
            name = direction.name
        )
    }
    Card(
        elevation = 5.dp,
        shape = RoundedCornerShape(5.dp),
        modifier = Modifier
            .padding(top = 5.dp, bottom = 5.dp, start = 10.dp, end = 10.dp)
            .fillMaxSize()
            .height(150.dp)
            .clickable {
                navController.navigate(route = Screens.DevicesShow.passDepartement(direction.name))
            }
    ) {
        Column() {
            Image(
                painter = painterResource(id = R.drawable.courthouse),
                contentDescription = null,
                contentScale = ContentScale.Fit,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(50.dp)
            )

            Column(modifier = Modifier.padding(10.dp)) {
                Text(
                    text = direction.name,
                    fontWeight = FontWeight.Bold,
                    fontFamily = Constants.fontfamily,
                    fontSize = 18.sp,
                    textAlign = TextAlign.Start,
                    modifier = Modifier.align(Alignment.Start),
                )
//                Text(
//                    text = direction.description,
//                    fontWeight = FontWeight.Normal,
//                    fontFamily = Constants.fontfamily,
//                    modifier = Modifier.align(Alignment.Start),
//                    textAlign = TextAlign.Start,
//                    overflow = TextOverflow.Ellipsis
//                )

                Text(
                    text = "Delete",
                    fontWeight = FontWeight.Normal,
                    fontFamily = Constants.fontfamily,
                    modifier = Modifier
                        .align(Alignment.CenterHorizontally)
                        .clickable {
                            showDialog.value = true
                        },
                    textAlign = TextAlign.Start,
                    color = Color.Red
                )
            }

        }

    }
}

@Composable
fun DeleteDepDialog(
    setShowDialog: (Boolean) -> Unit,
    delDepViewModel: DevicesViewModel,
    showDepViewModel: DirectionsViewModel,
    name: String,
) {
    val context = LocalContext.current

    val deleteDepFlow = delDepViewModel.DeleteDepState.collectAsStateWithLifecycle()


    Dialog(onDismissRequest = { setShowDialog(false) }) {
        Surface(shape = RoundedCornerShape(10.dp), color = Color.White) {
            Column(
                modifier = Modifier.padding(20.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.SpaceBetween
            ) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = "Delete Department",
                        fontFamily = Constants.fontfamily,
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Bold
                    )

                    Icon(
                        imageVector = Icons.Filled.Close,
                        contentDescription = null,
                        tint = colorResource(id = android.R.color.darker_gray),
                        modifier = Modifier
                            .width(24.dp)
                            .height(24.dp)
                            .clickable { setShowDialog(false) }
                    )
                }
                Spacer(modifier = Modifier.height(20.dp))

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Button(
                        onClick = {
                            delDepViewModel.deleteDep(name)
                        }, modifier = Modifier
                            .height(35.dp)
                            .width(100.dp),
                        colors = ButtonDefaults.buttonColors(
                            backgroundColor = Color.Red, contentColorFor(
                                backgroundColor = Color.White
                            )
                        )
                    ) {
                        Text(
                            text = "Delete",
                            color = Color.White,
                            fontFamily = Constants.fontfamily
                        )
                    }

                    Button(
                        onClick = {
                            setShowDialog(false)
                        }, modifier = Modifier
                            .height(35.dp)
                            .width(100.dp),
                        colors = ButtonDefaults.buttonColors(
                            backgroundColor = Color.Green,
                            contentColorFor(
                                backgroundColor = Color.White
                            )
                        )
                    ) {
                        Text(
                            text = "Cancel",
                            color = Color.White,
                            fontFamily = Constants.fontfamily
                        )
                    }
                }

            }
        }

    }

    deleteDepFlow?.value?.let {
        when (it) {
            is Resource.Error -> {
                Toast.makeText(context, it.message.toString(), Toast.LENGTH_SHORT).show()
            }

            is Resource.Success -> {
                LaunchedEffect(Unit) {
                    if (it.data.equals("Success")) {
                        Toast.makeText(
                            context,
                            "department deleted successfully",
                            Toast.LENGTH_SHORT
                        ).show()
                        showDepViewModel.getDirection()
                        setShowDialog(false)
                    } else {
                        Toast.makeText(context, "unknown error!!", Toast.LENGTH_SHORT).show()
                    }
                }
            }

            is Resource.Loading -> {}
        }
    }
}


@Preview(showSystemUi = true, showBackground = true)
@Composable
fun devicespreview() {
    Devices(navController = rememberNavController())
}