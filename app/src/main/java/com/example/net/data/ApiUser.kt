package com.example.net.data

import com.example.net.data.model.Respo
import com.example.net.data.model.User
import com.example.net.data.model.User1
import com.example.net.data.model.UserRes
import com.example.net.utils.Constants.Companion.USERS_URL
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiUser {
    @POST(USERS_URL)
    suspend fun addUser(@Body user: UserRes): Response<UserRes>

    @POST("users/log")
    suspend fun logUser(
        @Query("username") username : String,
        @Query("password") password: String,
    ): String
}