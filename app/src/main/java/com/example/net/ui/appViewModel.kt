package com.example.net.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.net.data.model.UserRes
import com.example.net.repository.Repository
import com.example.net.utils.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class appViewModel @Inject constructor(private val repo: Repository) : ViewModel() {
    //-------------------------------signup methode---------------------------------------------------
    private val _Addstate = MutableStateFlow<Resource<String>?>(null)
    val myresponse: StateFlow<Resource<String>?> = _Addstate


    fun addUser(user: UserRes) {

        viewModelScope.launch {
            val response = repo.addUser(user)
            _Addstate.value = response
        }
    }

    //-----------------------------------------------login methode--------------------------------------

    private val _logState = MutableStateFlow<Resource<String>?>(null)
    val logresponse: StateFlow<Resource<String>?> = _logState

    fun logUser(username: String, password: String) = viewModelScope.launch {
        val response = repo.logUser(username, password)
        _logState.value = response
    }

}