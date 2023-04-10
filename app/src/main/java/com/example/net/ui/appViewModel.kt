package com.example.net.ui

import android.util.Log
import android.widget.Toast
import androidx.compose.ui.platform.LocalContext
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.net.data.model.Respo
import com.example.net.data.model.User
import com.example.net.data.model.User1
import com.example.net.data.model.UserRes
import com.example.net.repository.Repository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import retrofit2.Response
import javax.inject.Inject

@HiltViewModel
class appViewModel @Inject constructor(private val repo: Repository) : ViewModel() {
    //-------------------------------signup methode---------------------------------------------------
    private val _Addstate: MutableStateFlow<UserRes?> = MutableStateFlow(null)
    val myresponse: StateFlow<UserRes?> = _Addstate


    fun addUser(user: UserRes) {

        viewModelScope.launch {
            try {
                val response = repo.addUser(user)
                _Addstate.value = response.body()
                Log.d("respoooooooooooooooooooooooooo", response.body().toString())
                Log.d("respoooooooooooooooooooooooooo", response.message())
                Log.d("respoooooooooooooooooooooooooo", response.code().toString())

            } catch (e: java.lang.Exception) {
                Log.d("rrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrr", e.message.toString())
            }
        }
    }

    //-----------------------------------------------login methode--------------------------------------
    private val _logState: MutableStateFlow<String> = MutableStateFlow("")
    val logresponse: StateFlow<String> = _logState

    fun logUser(username: String, password: String) {
        try {
            viewModelScope.launch {
                val response = repo.logUser(username, password)
                _logState.value = response
                Log.d("respoooooooooooooooooooooooooo", response)

            }
        } catch (e: Exception) {
            Log.d("mmmain", e.message.toString())
        }
    }
}