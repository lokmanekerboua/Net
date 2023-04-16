package com.example.net.ui.homeScreens.addnew

import android.widget.Toast
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Icon
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.material.TextFieldDefaults
import androidx.compose.material.contentColorFor
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavController
import com.example.net.R
import com.example.net.data.model.DirectionDevices
import com.example.net.ui.homeScreens.devicesShow.DevicesViewModel
import com.example.net.utils.Constants
import com.example.net.utils.Resource
import java.lang.Integer.parseInt

@Composable
fun AddNewDevice(departemnt: String, navController: NavController) {
    val context = LocalContext.current
    var name by remember() {
        mutableStateOf("")
    }

    var ip by remember {
        mutableStateOf("")
    }

    var bloc by remember {
        mutableStateOf("")
    }
    var floor by remember {
        mutableStateOf("")
    }

    var type by remember {
        mutableStateOf("")
    }


    val addDevice: DevicesViewModel = hiltViewModel()

    val addHoteFlow = addDevice.addNewHoteResponse.collectAsStateWithLifecycle()

    Box(modifier = Modifier.fillMaxSize()) {
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
                        text = "Add New Department", fontWeight = FontWeight.Bold,
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
            Column(
                modifier = Modifier
                    .fillMaxSize(1f)
                    .padding(start = 20.dp, end = 20.dp),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                OutlinedTextField(
                    value = name,
                    onValueChange = {
                        name = it
                    },
                    modifier = Modifier.fillMaxWidth(),
                    enabled = true,
                    readOnly = false,
                    textStyle = TextStyle(
                        fontSize = 15.sp,
                        fontFamily = Constants.fontfamily,
                        fontWeight = FontWeight.Normal,
                        color = Color.Black
                    ),
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),
                    label = { Text(text = "name", fontFamily = Constants.fontfamily) },
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
                OutlinedTextField(
                    value = ip,
                    onValueChange = {
                        ip = it
                    },
                    modifier = Modifier.fillMaxWidth(),
                    enabled = true,
                    readOnly = false,
                    textStyle = TextStyle(
                        fontSize = 15.sp,
                        fontFamily = Constants.fontfamily,
                        fontWeight = FontWeight.Normal,
                        color = Color.Black
                    ),
                    label = { Text(text = "Ip", fontFamily = Constants.fontfamily) },
                    maxLines = 1,
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
                    visualTransformation = VisualTransformation.None,
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
                OutlinedTextField(
                    value = bloc,
                    onValueChange = {
                        bloc = it
                    },
                    modifier = Modifier.fillMaxWidth(),
                    enabled = true,
                    readOnly = false,
                    textStyle = TextStyle(
                        fontSize = 15.sp,
                        fontFamily = Constants.fontfamily,
                        fontWeight = FontWeight.Normal,
                        color = Color.Black
                    ),
                    label = { Text(text = "Bloc", fontFamily = Constants.fontfamily) },
                    maxLines = 1,
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
                    visualTransformation = VisualTransformation.None,
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
                OutlinedTextField(
                    value = floor.toString(),
                    onValueChange = {
                        floor = it
                    },
                    modifier = Modifier.fillMaxWidth(),
                    enabled = true,
                    readOnly = false,
                    textStyle = TextStyle(
                        fontSize = 15.sp,
                        fontFamily = Constants.fontfamily,
                        fontWeight = FontWeight.Normal,
                        color = Color.Black
                    ),
                    label = { Text(text = "Floor", fontFamily = Constants.fontfamily) },
                    maxLines = 1,
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Decimal),
                    visualTransformation = VisualTransformation.None,
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
                OutlinedTextField(
                    value = type,
                    onValueChange = {
                        type = it
                    },
                    modifier = Modifier.fillMaxWidth(),
                    enabled = true,
                    readOnly = false,
                    textStyle = TextStyle(
                        fontSize = 15.sp,
                        fontFamily = Constants.fontfamily,
                        fontWeight = FontWeight.Normal,
                        color = Color.Black
                    ),
                    label = { Text(text = "Type", fontFamily = Constants.fontfamily) },
                    maxLines = 1,
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
                    visualTransformation = VisualTransformation.None,
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
                Button(
                    onClick = {
                        if (name.trim().equals("") || ip.trim().equals("") || bloc.trim()
                                .equals("") || floor.trim().equals("") || type.trim().equals("")
                        ) {
                            Toast.makeText(
                                context,
                                "please fill correctly all fields !",
                                Toast.LENGTH_SHORT
                            ).show()
                        } else {
                            val host =
                                DirectionDevices(name, ip, bloc, parseInt(floor), departemnt, type)
                            addDevice.AddNewHote(host)
                        }
                    }, modifier = Modifier
                        .height(40.dp)
                        .width(150.dp),
                    colors = ButtonDefaults.buttonColors(
                        backgroundColor = Color.Black, contentColorFor(
                            backgroundColor = Color.White
                        )
                    )
                ) {
                    Text(text = "ADD", color = Color.White, fontFamily = Constants.fontfamily)
                }
            }
        }
    }

    addHoteFlow?.value?.let {
        when (it) {
            is Resource.Error -> {
                LaunchedEffect(Unit) {
                    Toast.makeText(context, it.message.toString(), Toast.LENGTH_SHORT).show()
                }
            }

            is Resource.Success -> {
                LaunchedEffect(Unit) {
                    if (it.data.equals("Success")) {
                        Toast.makeText(context, "Host added successfully", Toast.LENGTH_SHORT)
                            .show()
                        name = ""
                        ip = ""
                        bloc = ""
                        floor = ""
                        type = ""
                    } else {
                        Toast.makeText(context, "Unknown Error", Toast.LENGTH_SHORT).show()
                    }
                }
            }

            is Resource.Loading -> {}
        }
    }
}