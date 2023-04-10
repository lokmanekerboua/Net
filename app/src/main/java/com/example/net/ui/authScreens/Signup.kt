package com.example.net.ui.authScreens

import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.net.data.model.User
import com.example.net.data.model.UserRes
import com.example.net.ui.appViewModel
import com.example.net.ui.graphs.Screens
import com.example.net.utils.Constants

@Composable
fun Signup(navController: NavController) {

    val appViewModel: appViewModel = hiltViewModel()
    val state by appViewModel.myresponse.collectAsStateWithLifecycle()

    var companyname by remember {
        mutableStateOf("")
    }
    var name by remember {
        mutableStateOf("")
    }
    var birthyear by remember {
        mutableStateOf("")
    }

    var email by remember {
        mutableStateOf("")
    }
    var password by remember {
        mutableStateOf("")
    }
    var username by remember {
        mutableStateOf("")
    }


    val user = UserRes(companyname, name, birthyear, "A", "N", password, email, username)
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .padding(50.dp),
        contentAlignment = Alignment.Center
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(rememberScrollState()),
            verticalArrangement = Arrangement.SpaceBetween,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "SIGNUP",
                fontFamily = Constants.fontfamily,
                fontWeight = FontWeight.Bold,
                fontSize = 30.sp
            )
            Divider()
            Spacer(modifier = Modifier.height(40.dp))
            Column(
                modifier = Modifier.fillMaxWidth(),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                OutlinedTextField(
                    value = companyname,
                    onValueChange = { companyname = it },
                    modifier = Modifier.fillMaxWidth(),
                    enabled = true,
                    readOnly = false,
                    textStyle = TextStyle(
                        fontSize = 15.sp,
                        fontFamily = Constants.fontfamily,
                        fontWeight = FontWeight.Normal,
                        color = Color.Black
                    ),
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
                    label = { Text(text = "Company name", fontFamily = Constants.fontfamily) },
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
                    )
                )

                Spacer(modifier = Modifier.height(10.dp))
                OutlinedTextField(
                    value = name,
                    onValueChange = { name = it },
                    modifier = Modifier.fillMaxWidth(),
                    enabled = true,
                    readOnly = false,
                    textStyle = TextStyle(
                        fontSize = 15.sp,
                        fontFamily = Constants.fontfamily,
                        fontWeight = FontWeight.Normal,
                        color = Color.Black
                    ),
                    label = { Text(text = "name", fontFamily = Constants.fontfamily) },
                    maxLines = 1,
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
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
                    )
                )

                Spacer(modifier = Modifier.height(10.dp))
                OutlinedTextField(
                    value = birthyear,
                    onValueChange = { birthyear = it },
                    modifier = Modifier.fillMaxWidth(),
                    enabled = true,
                    readOnly = false,
                    textStyle = TextStyle(
                        fontSize = 15.sp,
                        fontFamily = Constants.fontfamily,
                        fontWeight = FontWeight.Normal,
                        color = Color.Black
                    ),
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                    label = { Text(text = "year of birth", fontFamily = Constants.fontfamily) },
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
                    )

                )
                Spacer(modifier = Modifier.height(10.dp))
                OutlinedTextField(
                    value = password,
                    onValueChange = { password = it },
                    modifier = Modifier.fillMaxWidth(),
                    enabled = true,
                    readOnly = false,
                    textStyle = TextStyle(
                        fontSize = 15.sp,
                        fontFamily = Constants.fontfamily,
                        fontWeight = FontWeight.Normal,
                        color = Color.Black
                    ),
                    label = { Text(text = "password", fontFamily = Constants.fontfamily) },
                    maxLines = 1,
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
                    visualTransformation = PasswordVisualTransformation(),
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
                    )
                )

                Spacer(modifier = Modifier.height(10.dp))
                OutlinedTextField(
                    value = email,
                    onValueChange = { email = it },
                    modifier = Modifier.fillMaxWidth(),
                    enabled = true,
                    readOnly = false,
                    textStyle = TextStyle(
                        fontSize = 15.sp,
                        fontFamily = Constants.fontfamily,
                        fontWeight = FontWeight.Normal,
                        color = Color.Black
                    ),
                    label = { Text(text = "email", fontFamily = Constants.fontfamily) },
                    maxLines = 1,
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
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
                    )
                )

                Spacer(modifier = Modifier.height(10.dp))
                OutlinedTextField(
                    value = username,
                    onValueChange = { username = it },
                    modifier = Modifier.fillMaxWidth(),
                    enabled = true,
                    readOnly = false,
                    textStyle = TextStyle(
                        fontSize = 15.sp,
                        fontFamily = Constants.fontfamily,
                        fontWeight = FontWeight.Normal,
                        color = Color.Black
                    ),
                    label = { Text(text = "username", fontFamily = Constants.fontfamily) },
                    maxLines = 1,
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
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
                    )
                )

                Spacer(modifier = Modifier.height(10.dp))

            }
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                Button(
                    onClick = {
                        appViewModel.addUser(user)
                    },
                    modifier = Modifier
                        .height(40.dp)
                        .width(150.dp),
                    colors = ButtonDefaults.buttonColors(
                        backgroundColor = Color.Black, contentColorFor(
                            backgroundColor = Color.White
                        )
                    )
                ) {
                    Text(text = "Signup", color = Color.White, fontFamily = Constants.fontfamily)
                }
                Spacer(modifier = Modifier.height(10.dp))
                Row {
                    Text(
                        text = "Already have account? ",
                        fontFamily = Constants.fontfamily,
                        fontSize = 12.sp
                    )
                    Text(text = "Login",
                        fontFamily = Constants.fontfamily,
                        fontSize = 12.sp,
                        modifier = Modifier.clickable {
                            navController.navigate(Screens.LoginScreen.route) {
                                popUpTo(Screens.LoginScreen.route) {
                                    inclusive = true
                                }
                            }
                        })
                }
            }
        }
    }
}

@Preview(showSystemUi = true, showBackground = true)
@Composable
fun showSignup() {
    Signup(navController = rememberNavController())
}