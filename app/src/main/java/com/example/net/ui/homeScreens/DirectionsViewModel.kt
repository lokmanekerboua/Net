package com.example.net.ui.homeScreens

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.net.data.model.Direction
import com.example.net.repository.Repository
import com.example.net.utils.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DirectionsViewModel @Inject constructor(private val repository: Repository) : ViewModel() {

    init {
        getDirection()
    }

    private val _GetDirectionState = MutableStateFlow(emptyList<Direction>())
    val getDirectionResponse: StateFlow<List<Direction>> get() = _GetDirectionState

    fun getDirection() = viewModelScope.launch {
        val response = repository.getDirections()
        _GetDirectionState.value = response
    }
}