package com.example.net.repository

import com.example.net.data.ApiUser
import com.example.net.data.model.UserRes
import com.example.net.utils.Resource
import retrofit2.Response
import javax.inject.Inject

class Repository @Inject constructor(private val apiUser: ApiUser) {
    suspend fun addUser(user: UserRes): Resource<String> {
        return try {
            val result = apiUser.addUser(user)
            Resource.Success(result)
        } catch (ex: Exception) {
            ex.printStackTrace()
            Resource.Error(ex.message.toString())
        }
    }

    suspend fun logUser(username: String, password: String): Resource<String> {
        return try {
            val result = apiUser.logUser(username, password)
            Resource.Success(result)
        } catch (ex: Exception) {
            ex.printStackTrace()
            Resource.Error(ex.message.toString())
        }
    }
}