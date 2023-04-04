package com.example.net.ui.authScreens

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
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
import com.example.net.utils.Constants.Companion.fontfamily

@Composable
fun Login() {

    var email by remember {
        mutableStateOf("")
    }

    var password by remember {
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
                text = "LOGIN",
                fontFamily = fontfamily,
                fontWeight = FontWeight.Bold,
                fontSize = 30.sp
            )
            Divider()
            Spacer(modifier = Modifier.height(60.dp))
            OutlinedTextField(
                value = email,
                onValueChange = { email = it },
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
                label = { Text(text = "email", fontFamily = fontfamily) },
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
                    fontFamily = fontfamily,
                    fontWeight = FontWeight.Normal,
                    color = Color.Black
                ),
                label = { Text(text = "password", fontFamily = fontfamily) },
                maxLines = 1,
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
                visualTransformation = PasswordVisualTransformation()
            )
            Spacer(modifier = Modifier.height(5.dp))
            Box(modifier = Modifier.fillMaxWidth(), contentAlignment = Alignment.CenterEnd) {
                Text(
                    text = "Forgot your password!",
                    fontFamily = fontfamily,
                    fontSize = 12.sp,
                    modifier = Modifier.clickable {

                    })
            }
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
                Text(text = "Login", color = Color.White, fontFamily = fontfamily)
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
                Text(text = "Signup", color = Color.Black, fontFamily = fontfamily)
            }
        }

    }

}

@Preview(showBackground = true , showSystemUi = true)
@Composable
fun showlogin(){
    Login()
}