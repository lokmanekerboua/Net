package com.example.net.ui.authScreens

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
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
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.net.utils.Constants

@Composable
fun Signup() {
    var email by remember {
        mutableStateOf("")
    }

    var password by remember {
        mutableStateOf("")
    }
    var password2 by remember {
        mutableStateOf("")
    }
    var companyname by remember {
        mutableStateOf("")
    }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .padding(50.dp), contentAlignment = Alignment.Center
    ) {
        Column(
            modifier = Modifier.fillMaxWidth(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "SIGNUP",
                fontFamily = Constants.fontfamily,
                fontWeight = FontWeight.Bold,
                fontSize = 30.sp
            )
            Divider()
            Spacer(modifier = Modifier.height(60.dp))

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

                )
            Spacer(modifier = Modifier.height(20.dp))

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
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),
                label = { Text(text = "email", fontFamily = Constants.fontfamily) },
                maxLines = 1,
                minLines = 1,

                )
            Spacer(modifier = Modifier.height(20.dp))
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
                visualTransformation = PasswordVisualTransformation()
            )

            Spacer(modifier = Modifier.height(20.dp))
            OutlinedTextField(
                value = password2,
                onValueChange = { password2 = it },
                modifier = Modifier.fillMaxWidth(),
                enabled = true,
                readOnly = false,
                textStyle = TextStyle(
                    fontSize = 15.sp,
                    fontFamily = Constants.fontfamily,
                    fontWeight = FontWeight.Normal,
                    color = Color.Black
                ),
                label = { Text(text = "Re_Enter password", fontFamily = Constants.fontfamily) },
                maxLines = 1,
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
                visualTransformation = PasswordVisualTransformation()
            )

            Spacer(modifier = Modifier.height(20.dp))
            Button(
                onClick = {

                }, modifier = Modifier
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
            OutlinedButton(
                onClick = {

                },
                modifier = Modifier
                    .width(150.dp)
                    .height(40.dp),
                border = BorderStroke(1.5.dp, color = Color.Black)
            ) {
                Text(text = "Go To Login", color = Color.Black, fontFamily = Constants.fontfamily)
            }
        }


    }
}