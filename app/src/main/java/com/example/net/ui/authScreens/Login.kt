package com.example.net.ui.authScreens

import android.util.Log
import android.widget.Toast
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.net.R
import com.example.net.ui.appViewModel
import com.example.net.ui.graphs.Screens
import com.example.net.utils.Constants.Companion.fontfamily
import com.example.net.utils.Resource
import java.util.regex.Pattern

@Composable
fun Login(navController: NavController) {

    val context = LocalContext.current
    val appViewModel: appViewModel = hiltViewModel()
    val logFlow = appViewModel?.logresponse?.collectAsStateWithLifecycle()

    var usernameError by remember {
        mutableStateOf(false)
    }
    var passwordError by remember {
        mutableStateOf(false)
    }
    var username by remember {
        mutableStateOf("")
    }

    var password by remember {
        mutableStateOf("")
    }

    var passwordVisible by remember {
        mutableStateOf(false)
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
                value = username,
                isError = usernameError,
                onValueChange = {
                    username = it
                    usernameError = !isValidEntry(it)
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
                label = { Text(text = "username", fontFamily = fontfamily) },
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
                value = password,
                isError = passwordError,
                onValueChange = {
                    password = it
                    passwordError = !isValidatePassword(it)
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
                label = { Text(text = "password", fontFamily = fontfamily) },
                maxLines = 1,
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
                visualTransformation = if (passwordVisible) VisualTransformation.None else PasswordVisualTransformation(),
                trailingIcon = {
                    IconButton(onClick = { passwordVisible = !passwordVisible }) {
                        Icon(
                            painter = if (passwordVisible) painterResource(id = R.drawable.baseline_visibility_24) else {
                                painterResource(id = R.drawable.baseline_visibility_off_24)
                            }, contentDescription = null
                        )
                    }
                },
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
                    if (username.trim().equals("") || password.trim().equals("")) {
                        Toast.makeText(
                            context,
                            "please fill all fields",
                            Toast.LENGTH_SHORT
                        ).show()
                    } else if (!usernameError || !passwordError) {
                        appViewModel.logUser(username, password)
                    } else {
                        Toast.makeText(
                            context,
                            "username or password mal typed",
                            Toast.LENGTH_SHORT
                        ).show()
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
                Text(text = "Login", color = Color.White, fontFamily = fontfamily)
            }
            Spacer(modifier = Modifier.height(10.dp))
            OutlinedButton(
                onClick = {
                    navController.navigate(Screens.SignupScreen.route)
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
    logFlow?.value?.let {
        when (it) {
            is Resource.Error -> {
                Toast.makeText(context, it.message, Toast.LENGTH_SHORT).show()
                Log.d("faail", "the fail is : " + it.message)
            }
            is Resource.Loading -> {}
            is Resource.Success -> {
                Log.d("messsge", "the response from server is : " + it.data)
                if (it.data.equals("errorcredentials")) {
                    usernameError = true
                    passwordError = true
                    Toast.makeText(
                        context,
                        "username or password are incorrect",
                        Toast.LENGTH_SHORT
                    ).show()
                } else if (it.data.equals("errorpassword")) {
                    Toast.makeText(
                        context,
                        "incorrect password",
                        Toast.LENGTH_SHORT
                    ).show()
                } else {
                    LaunchedEffect(Unit) {
                        navController.popBackStack()
                        navController.navigate(Screens.HomeScreen.route)
                    }
                }
            }
        }
    }

}

fun isValidEntry(username: String?) =
    Pattern.compile(
        "^(?=.{4,20}$)(?![_.])(?!.*[_.]{2})[a-zA-Z0-9._]+(?<![_.])$",
        Pattern.CASE_INSENSITIVE
    ).matcher(username).find()

fun isValidatePassword(password: String?) = Pattern.compile(
    "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#\$%^&+=])(?=\\S+$).{4,}$",
    Pattern.CASE_INSENSITIVE
).matcher(password).find()

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun Showlogin() {
    Login(navController = rememberNavController())
}