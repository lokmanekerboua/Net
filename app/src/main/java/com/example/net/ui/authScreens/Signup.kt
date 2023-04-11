package com.example.net.ui.authScreens

import android.util.Log
import android.widget.Toast
import androidx.compose.foundation.*
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
import com.example.net.data.model.UserRes
import com.example.net.ui.appViewModel
import com.example.net.ui.graphs.Screens
import com.example.net.utils.Constants
import com.example.net.utils.Resource
import java.util.regex.Pattern

@Composable
fun Signup(navController: NavController) {

//----------------------------------------------------initialization------------------------------------------

    val context = LocalContext.current
    val appViewModel: appViewModel = hiltViewModel()
    val SignupFlow = appViewModel.myresponse.collectAsStateWithLifecycle()

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

    var companyValid by remember {
        mutableStateOf(false)
    }

    var nameValid by remember {
        mutableStateOf(false)
    }

    var birthyearValid by remember {
        mutableStateOf(false)
    }

    var passwordValid by remember {
        mutableStateOf(false)
    }

    var emailValid by remember {
        mutableStateOf(false)
    }

    var usernameValid by remember {
        mutableStateOf(false)
    }

    var passwordVisible by remember {
        mutableStateOf(false)
    }

    val user = UserRes(companyname, name, birthyear, password, email, username)

//----------------------------------------------------------------ui----------------------------------------------------
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

//-------------------------------------------------company text field----------------------------------------------------
                OutlinedTextField(
                    value = companyname,
                    isError = companyValid,
                    onValueChange = {
                        companyname = it
                        companyValid = !isValidEntry(it)
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

//-------------------------------------------------name text field----------------------------------------------------
                OutlinedTextField(
                    value = name,
                    isError = nameValid,
                    onValueChange = {
                        name = it
                        nameValid = !isValidEntry(it)
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

//-------------------------------------------------birthyear text field----------------------------------------------------
                OutlinedTextField(
                    value = birthyear,
                    isError = birthyearValid,
                    onValueChange = {
                        birthyear = it
                        birthyearValid = !isvalidYear(it)
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

//-------------------------------------------------password text field----------------------------------------------------
                OutlinedTextField(
                    value = password,
                    isError = passwordValid,
                    onValueChange = {
                        password = it
                        passwordValid = !isValidatePassword(it)
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
                    label = { Text(text = "password", fontFamily = Constants.fontfamily) },
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
                    )
                )

                Spacer(modifier = Modifier.height(10.dp))

//-------------------------------------------------email text field----------------------------------------------------
                OutlinedTextField(
                    value = email,
                    isError = emailValid,
                    onValueChange = {
                        email = it
                        emailValid = !isValidEmail(it)
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

//-------------------------------------------------username text field----------------------------------------------------
                OutlinedTextField(
                    value = username,
                    isError = usernameValid,
                    onValueChange = {
                        username = it
                        usernameValid = !isValidEntry(it)
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

//-------------------------------------------------Buttons----------------------------------------------------
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {

//-------------------------------------------------login Button----------------------------------------------------
                Button(
                    onClick = {
                        if (companyname.trim().equals("") && name.trim()
                                .equals("") && birthyear.trim().equals("") && password.trim()
                                .equals("") && email.trim().equals("") && username.trim().equals("")
                        ) {
                            Toast.makeText(context, "please fill all fields", Toast.LENGTH_SHORT)
                                .show()
                        } else {
                            appViewModel.addUser(user)
                        }
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

//-------------------------------------------------signup text----------------------------------------------------
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

//------------------------------------------------signup Flow observe-----------------------------------------------
    SignupFlow?.value?.let {
        when (it) {
            is Resource.Error -> {
                Toast.makeText(context, it.message, Toast.LENGTH_SHORT).show()
                Log.d("faail", "the fail is : " + it.message)
            }
            is Resource.Loading -> {}
            is Resource.Success -> {
                if (it.data.equals("usernameerror")) {
                    LaunchedEffect(Unit) {
                        usernameValid = true
                        Toast.makeText(context, "username already used", Toast.LENGTH_SHORT).show()
                    }
                } else if (it.data.equals("error")) {
                    LaunchedEffect(Unit) {
                        Toast.makeText(
                            context,
                            "unknown error occurred try again",
                            Toast.LENGTH_SHORT
                        ).show()
                    }
                } else {
                    LaunchedEffect(Unit) {
                        Toast.makeText(context, "Successfully signup", Toast.LENGTH_SHORT).show()
                        navController.popBackStack()
                        navController.navigate(Screens.LoginScreen.route)
                    }
                }
            }
        }
    }
}

//--------------------------------------------------------------check methods--------------------------------------------
fun isvalidYear(year: String) =
    Pattern.compile(
        "^[0-9]{4}\$",
        Pattern.CASE_INSENSITIVE
    ).matcher(year).find()

fun isValidEmail(email: String) =
    Pattern.compile(
        "^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$",
        Pattern.CASE_INSENSITIVE
    ).matcher(email).find()

//--------------------------------------------------------------preview--------------------------------------------
@Preview(showSystemUi = true, showBackground = true)
@Composable
fun showSignup() {
    Signup(navController = rememberNavController())
}