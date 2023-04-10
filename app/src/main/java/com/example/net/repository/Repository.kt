package com.example.net.repository

import com.example.net.data.ApiUser
import com.example.net.data.model.Respo
import com.example.net.data.model.User
import com.example.net.data.model.User1
import com.example.net.data.model.UserRes
import retrofit2.Response
import javax.inject.Inject

class Repository @Inject constructor(private val apiUser: ApiUser) {
    suspend fun addUser(user: UserRes): Response<UserRes> {
        return apiUser.addUser(user)
    }

    suspend fun logUser(username: String, password: String): String {
        return apiUser.logUser(username, password)
    }
}