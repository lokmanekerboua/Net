package com.example.net.ui.homeScreens.addnew

import android.widget.Toast
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.*
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
import com.example.net.ui.homeScreens.devicesShow.DevicesViewModel
import com.example.net.utils.Constants
import com.example.net.utils.Resource

@Composable
fun AddNewDepartement(navController: NavController) {
    val context = LocalContext.current
    var name by remember() {
        mutableStateOf("")
    }

    var description by remember {
        mutableStateOf("")
    }

    val addDep: DevicesViewModel = hiltViewModel()

    val addDepartmentFlow = addDep.AddDirectionresponse.collectAsStateWithLifecycle()

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
                    value = description,
                    onValueChange = {
                        description = it
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
                    label = { Text(text = "description", fontFamily = Constants.fontfamily) },
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
                        if (name.trim().equals("") || description.trim().equals("")) {
                            Toast.makeText(
                                context,
                                "please fill all fields",
                                Toast.LENGTH_SHORT
                            ).show()
                        } else {
                            val dep = com.example.net.data.model.Direction(
                                name.trim().uppercase(),
                                description
                            )
                            addDep.addDirection(dep)
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

    addDepartmentFlow?.value?.let {
        when (it) {
            is Resource.Error -> {
                Toast.makeText(context, it.message, Toast.LENGTH_SHORT).show()
            }

            is Resource.Success -> {
                LaunchedEffect(Unit) {
                    Toast.makeText(context, "ADD DEPARTMENT SUCCESSFULLY", Toast.LENGTH_SHORT)
                        .show()
                }
            }

            is Resource.Loading -> {}
        }
    }
}