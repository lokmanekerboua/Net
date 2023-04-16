package com.example.net.ui.homeScreens.devicesShow

import android.util.Log
import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.selection.selectableGroup
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.RadioButton
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.TextFieldDefaults
import androidx.compose.material.contentColorFor
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.ArrowBack
import com.example.net.R
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Phone
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
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
import com.example.net.data.model.DirectionDevices
import com.example.net.data.model.PaneDevices
import com.example.net.ui.graphs.Screens
import com.example.net.utils.Constants
import com.example.net.utils.Constants.Companion.fontfamily
import com.example.net.utils.Resource

@Composable
fun DevicesShow(departement: String, navController: NavController) {
    val context = LocalContext.current
    val showDevicesViewModel: DevicesViewModel = hiltViewModel()
    val showDevicesFlow by showDevicesViewModel.getDevicesResponse.collectAsStateWithLifecycle()

    showDevicesViewModel.getDirectionDevices(departement)
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
                        imageVector = Icons.Default.ArrowBack,
                        contentDescription = null,
                        modifier = Modifier
                            .size(24.dp)
                            .clickable {
                                navController.popBackStack()
                            }
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
                            navController.navigate(Screens.AddnewDevice.passDepartement(departement))
                        })
                }
            }

            LazyVerticalGrid(
                columns = GridCells.Fixed(1),
                contentPadding = PaddingValues(vertical = 12.dp, horizontal = 12.dp)
            ) {
                items(showDevicesFlow) { devices ->
                    DevicesCardShow(device = devices, showDevicesViewModel)
                }
            }
        }
    }
}


@Composable
fun DevicesCardShow(device: DirectionDevices, showDevicesViewModel: DevicesViewModel) {

    val showDialog = remember {
        mutableStateOf(false)
    }

    val deleteDialogShow = remember {
        mutableStateOf(false)
    }

    if (showDialog.value) {
        customDialog(
            setShowDialog = { showDialog.value = it },
            showDevicesViewModel,
            device.name,
            device.type,
            device.bloc,
            device.floor
        )
    }

    if (deleteDialogShow.value) {
        DeleteDialog(
            setShowDialog = { deleteDialogShow.value = it },
            showDevicesViewModel,
            name = device.name,
            ip = device.ip,
            bloc = device.bloc,
            floor = device.floor,
            direction = device.direction,
            type = device.type
        )
    }
    Card(
        elevation = 5.dp,
        shape = RoundedCornerShape(5.dp),
        modifier = Modifier
            .padding(top = 5.dp, bottom = 5.dp, start = 10.dp, end = 10.dp)
            .fillMaxWidth()
            .height(120.dp)
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceAround
        ) {
            Image(
                painter = painterResource(id = R.drawable.pc),
                contentDescription = null,
                contentScale = ContentScale.Fit,
                modifier = Modifier
                    .size(35.dp)
            )

            Column(
                modifier = Modifier
                    .padding(10.dp)
                    .fillMaxHeight(),
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
                            append("IP: ")
                        }
                        append(device.ip)
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
                            append("Dep: ")
                        }
                        append(device.direction)
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
                    .padding(10.dp)
                    .fillMaxHeight(),
                verticalArrangement = Arrangement.SpaceBetween,
                horizontalAlignment = Alignment.Start
            ) {
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
                    fontFamily = fontfamily,
                    modifier = Modifier.align(Alignment.Start),
                    textAlign = TextAlign.Start,
                    overflow = TextOverflow.Ellipsis
                )
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
                    fontFamily = fontfamily,
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
                    fontFamily = fontfamily,
                    modifier = Modifier.align(Alignment.Start),
                    textAlign = TextAlign.Start,
                    overflow = TextOverflow.Ellipsis
                )
            }

            Column(
                modifier = Modifier
                    .padding(0.dp)
                    .fillMaxHeight(),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {

                Icon(
                    painter = painterResource(id = R.drawable.baseline_error_24),
                    contentDescription = null,
                    tint = Color.Red,
                    modifier = Modifier
                        .size(24.dp)
                        .clickable {
                            showDialog.value = true
                        }
                )
                Spacer(modifier = Modifier.height(20.dp))
                Icon(
                    painter = painterResource(id = R.drawable.baseline_delete_24),
                    contentDescription = null,
                    tint = Color.Red,
                    modifier = Modifier
                        .size(24.dp)
                        .clickable {
                            deleteDialogShow.value = true
                        }
                )
            }

        }

    }
}

@Composable
fun customDialog(
    setShowDialog: (Boolean) -> Unit,
    showDevicesViewModel: DevicesViewModel,
    name: String,
    type: String,
    bloc: String,
    floor: Int
) {
    var txtFieldError = remember { mutableSetOf("") }
    var txtField by remember { mutableStateOf("") }

    val context = LocalContext.current

    val addPanneFlow = showDevicesViewModel.AddPanneResponse.collectAsStateWithLifecycle()

    val radioOption = listOf("medium", "high")

    var selectedValue by remember {
        mutableStateOf(radioOption[0])
    }


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
                        text = "Report Device",
                        fontFamily = fontfamily,
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

                OutlinedTextField(
                    value = txtField,
                    onValueChange = {
                        txtField = it
                    },
                    modifier = Modifier.fillMaxWidth(),
                    enabled = true,
                    readOnly = false,
                    textStyle = TextStyle(
                        fontSize = 15.sp,
                        fontFamily = fontfamily,
                        fontWeight = FontWeight.Normal,
                        color = Color.Black
                    ),
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),
                    label = { Text(text = "Description", fontFamily = fontfamily) },
                    maxLines = 1,
                    minLines = 1,
                    colors = TextFieldDefaults.outlinedTextFieldColors(
                        textColor = Color.Black,
                        backgroundColor = Color.White,
                        cursorColor = Color.Black,
                        errorCursorColor = Color.Red,
                        errorBorderColor = Color.Red,
                        errorLabelColor = Color.Red,
                        focusedLabelColor = Color.Black,
                        focusedBorderColor = Color.Black,
                        unfocusedBorderColor = Color.Gray,
                        unfocusedLabelColor = Color.Gray
                    ),
                )

                Spacer(modifier = Modifier.height(20.dp))
                radioGroupe(
                    selectedValue,
                    onValueChanged = { value ->
                        selectedValue = value
                    },
                    radioOption
                )
                Spacer(modifier = Modifier.height(20.dp))

                Button(
                    onClick = {
                        if (!txtField.trim().equals("")) {
                            val paneDevices =
                                PaneDevices(name, type, bloc, floor, txtField, selectedValue)
                            showDevicesViewModel.addPanneDevice(paneDevices)
                        } else {
                            Toast.makeText(context, "please fill description", Toast.LENGTH_SHORT)
                                .show()
                        }
                    }, modifier = Modifier
                        .height(40.dp)
                        .width(150.dp),
                    colors = ButtonDefaults.buttonColors(
                        backgroundColor = Color.Red, contentColorFor(
                            backgroundColor = Color.White
                        )
                    )
                ) {
                    Text(
                        text = "Report Problem",
                        color = Color.White,
                        fontFamily = fontfamily
                    )
                }

            }
        }

    }

    addPanneFlow?.value?.let {
        when (it) {
            is Resource.Error -> {
                Toast.makeText(context, "report error", Toast.LENGTH_SHORT).show()
            }

            is Resource.Success -> {
                LaunchedEffect(Unit) {
                    if (it.data.equals("Success")) {
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


@Composable
fun DeleteDialog(
    setShowDialog: (Boolean) -> Unit,
    showDevicesViewModel: DevicesViewModel,
    name: String,
    ip: String,
    bloc: String,
    floor: Int,
    direction: String,
    type: String

) {
    val context = LocalContext.current

    val deleteDeviceFlow = showDevicesViewModel.DeleteDeviceState.collectAsStateWithLifecycle()


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
                        fontFamily = fontfamily,
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
                            val directionDevices =
                                DirectionDevices(name, ip, bloc, floor, direction, type)
                            showDevicesViewModel.deleteDeviceDep(directionDevices)
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
                            fontFamily = fontfamily
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
                            fontFamily = fontfamily
                        )
                    }
                }

            }
        }

    }

    deleteDeviceFlow?.value?.let {
        when (it) {
            is Resource.Error -> {
                Toast.makeText(context, it.message.toString(), Toast.LENGTH_SHORT).show()
            }

            is Resource.Success -> {
                LaunchedEffect(Unit) {
                    if (it.data.equals("Success")) {
                        Toast.makeText(context, "device deleted successfully", Toast.LENGTH_SHORT)
                            .show()
                        showDevicesViewModel.getDirectionDevices(direction)
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


@Composable
fun radioGroupe(
    selectedValue: String,
    onValueChanged: (String) -> Unit,
    radioOption: List<String>
) {

    Column(modifier = Modifier.selectableGroup()) {
        radioOption.forEach { label ->
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(20.dp)
                    .clickable(onClick = {
                        onValueChanged(label)
                    })
                    .padding(horizontal = 15.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                RadioButton(
                    modifier = Modifier.padding(end = 15.dp),
                    selected = label == selectedValue,
                    onClick = {
                        onValueChanged(label)
                    }
                )
                Text(text = label, fontFamily = fontfamily, fontSize = 14.sp)
            }
            Spacer(modifier = Modifier.height(15.dp))
        }
    }
}

