package com.example.net.ui.homeScreens

import android.widget.Toast
import androidx.compose.animation.animateColor
import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
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
import androidx.compose.material.Icon
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.contentColorFor
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.AddCircle
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Phone
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavController
import com.example.net.R
import com.example.net.data.model.DirectionDevices
import com.example.net.data.model.PaneDelete
import com.example.net.data.model.PaneDevices
import com.example.net.ui.homeScreens.devicesShow.DevicesViewModel
import com.example.net.utils.Constants
import com.example.net.utils.Resource

@Composable
fun PaneScreen(navController: NavController) {

    val context = LocalContext.current
    val PanDevicesViewModel: DevicesViewModel = hiltViewModel()
    PanDevicesViewModel.getPaneDevices()
    val DevicePaneFlow by PanDevicesViewModel.getPaneDevices.collectAsStateWithLifecycle()

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
                        text = "Broken Devices", fontWeight = FontWeight.Bold,
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
                contentPadding = PaddingValues(vertical = 12.dp, horizontal = 12.dp)
            ) {
                items(DevicePaneFlow) { device ->
                    PaneDevicesCardShow(device = device, PanDevicesViewModel)
                }
            }
        }
    }
}


@Composable
fun PaneDevicesCardShow(device: PaneDevices, showDevicesViewModel: DevicesViewModel) {
    val highcolor by rememberInfiniteTransition().animateColor(
        initialValue = Color.White,
        targetValue = Color.Red,
        animationSpec = infiniteRepeatable(
            tween(durationMillis = 300),
            repeatMode = RepeatMode.Reverse
        )
    )

    val midcolor by rememberInfiniteTransition().animateColor(
        initialValue = colorResource(id = R.color.white),
        targetValue = colorResource(id = R.color.yellow),
        animationSpec = infiniteRepeatable(
            tween(durationMillis = 300),
            repeatMode = RepeatMode.Reverse
        )
    )

    val dialogshoww = remember {
        mutableStateOf(false)
    }

    if (dialogshoww.value) {
        DeleteDialog(
            setShowDialog = { dialogshoww.value = it },
            showDevicesViewModel,
            name = device.name,
            bloc = device.bloc,
            floor = device.floor,
            type = device.type
        )
    }


    Card(
        elevation = 5.dp,
        shape = RoundedCornerShape(5.dp),
        modifier = Modifier
            .padding(top = 5.dp, bottom = 5.dp, start = 10.dp, end = 10.dp)
            .fillMaxWidth()
            .height(110.dp)
            .clickable {

            }
    ) {

        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceAround,
            modifier = Modifier.fillMaxSize()
        ) {
            Image(
                painter = painterResource(id = R.drawable.computer),
//                imageVector = Icons.Default.AddCircle,
                contentDescription = null,
                contentScale = ContentScale.Fit,
                modifier = Modifier.size(35.dp)
            )

            Column(
                modifier = Modifier
                    .padding(0.dp),
                verticalArrangement = Arrangement.SpaceBetween,
                horizontalAlignment = Alignment.Start
            ) {
                Text(
                    text = buildAnnotatedString {
                        withStyle(
                            style = SpanStyle(fontWeight = FontWeight.Bold)
                        ) {
                            append("Name: ")
                        }
                        append(device.name)

                    },
                    fontWeight = FontWeight.Normal,
                    fontFamily = Constants.fontfamily,
                    modifier = Modifier.align(Alignment.Start),
                    textAlign = TextAlign.Start,
                    overflow = TextOverflow.Ellipsis
                )
                Text(
                    text = buildAnnotatedString {
                        withStyle(
                            style = SpanStyle(fontWeight = FontWeight.Bold)
                        ) {
                            append("Type: ")
                        }
                        append(device.type)

                    },
                    fontWeight = FontWeight.Normal,
                    fontFamily = Constants.fontfamily,
                    modifier = Modifier.align(Alignment.Start),
                    textAlign = TextAlign.Start,
                    overflow = TextOverflow.Ellipsis
                )

                Text(
                    text = buildAnnotatedString {
                        withStyle(
                            style = SpanStyle(fontWeight = FontWeight.Bold)
                        ) {
                            append("Description: ")
                        }
                        append(device?.description)

                    },
                    fontWeight = FontWeight.Normal,
                    fontFamily = Constants.fontfamily,
                    textAlign = TextAlign.Start,
                    overflow = TextOverflow.Ellipsis
                )

            }

            Column(
                modifier = Modifier
                    .padding(top = 20.dp, bottom = 20.dp),
                verticalArrangement = Arrangement.SpaceBetween,
                horizontalAlignment = Alignment.Start
            ) {
                Text(
                    text = buildAnnotatedString {
                        withStyle(
                            style = SpanStyle(fontWeight = FontWeight.Bold)
                        ) {
                            append("Bloc: ")
                        }
                        append(device.bloc)

                    },
                    fontWeight = FontWeight.Normal,
                    fontFamily = Constants.fontfamily,
                    modifier = Modifier.align(Alignment.Start),
                    textAlign = TextAlign.Start,
                    overflow = TextOverflow.Ellipsis
                )

                Text(
                    text = buildAnnotatedString {
                        withStyle(
                            style = SpanStyle(fontWeight = FontWeight.Bold)
                        ) {
                            append("Floor: ")
                        }
                        append(device.floor.toString())

                    },
                    fontWeight = FontWeight.Normal,
                    fontFamily = Constants.fontfamily,
                    modifier = Modifier.align(Alignment.Start),
                    textAlign = TextAlign.Start,
                    overflow = TextOverflow.Ellipsis
                )
            }

            Column(
                modifier = Modifier
                    .padding(0.dp)
                    .fillMaxHeight(),
                verticalArrangement = Arrangement.SpaceAround,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.baseline_error_24),
                    contentDescription = null,
                    modifier = Modifier.size(24.dp),
                    tint = if (device.degree.equals("high")) highcolor else midcolor
                )

                Icon(
                    painter = painterResource(id = R.drawable.baseline_delete_24),
                    contentDescription = null,
                    modifier = Modifier
                        .size(24.dp)
                        .clickable {
                            dialogshoww.value = true
                        },
                    tint = Color.Red
                )
            }
        }

    }

}


@Composable
fun DeleteDialog(
    setShowDialog: (Boolean) -> Unit,
    showDevicesViewModel: DevicesViewModel,
    name: String,
    bloc: String,
    floor: Int,
    type: String

) {
    val context = LocalContext.current

    val deletePaneDeviceFlow =
        showDevicesViewModel.DeletePaneDeviceState.collectAsStateWithLifecycle()


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
                        text = "Delete Device",
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
                            val paneDevices = PaneDelete(name, type, bloc, floor)
                            showDevicesViewModel.deletePaneDevice(paneDevices)
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

    deletePaneDeviceFlow?.value?.let {
        when (it) {
            is Resource.Error -> {
                Toast.makeText(context, it.message.toString(), Toast.LENGTH_SHORT).show()
            }

            is Resource.Success -> {
                LaunchedEffect(Unit) {
                    if (it.data.equals("Success")) {
                        showDevicesViewModel.getPaneDevices()
                        Toast.makeText(context, "device deleted successfully", Toast.LENGTH_SHORT)
                            .show()
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
