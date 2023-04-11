package com.example.net.data.model

data class User(
    val company: String,
    val name: String,
    val birthyear: String,
    val password: String,
    val email: String,
    val username: String,
)

data class UserRes(
    val company: String,
    val name: String,
    val birthyear: String,
    val password: String,
    val email: String,
    val username: String,
)

data class User1(
    val username: String? = null,
    val password: String? = null
)

data class Respo(
    val resmessage: String,
)