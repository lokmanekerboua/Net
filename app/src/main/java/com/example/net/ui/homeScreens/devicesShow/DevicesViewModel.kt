package com.example.net.ui.homeScreens.devicesShow

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.net.data.model.*
import com.example.net.repository.Repository
import com.example.net.utils.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DevicesViewModel @Inject constructor(private val repository: Repository) : ViewModel() {

    private val _GetDevicesState = MutableStateFlow(emptyList<DirectionDevices>())
    val getDevicesResponse: StateFlow<List<DirectionDevices>> get() = _GetDevicesState

    fun getDirectionDevices(departement: String) = viewModelScope.launch {
        val response = repository.getDirectionDevices(departement)
        _GetDevicesState.value = response
    }

    //--------------------------------------------------add direction --------------------------------------------------
    private val _AddDirectionstate = MutableStateFlow<Resource<String>?>(null)
    val AddDirectionresponse: StateFlow<Resource<String>?> = _AddDirectionstate


    fun addDirection(direction: Direction) {

        viewModelScope.launch {
            val response = repository.adddirection(direction)
            _AddDirectionstate.value = response
        }
    }

//-----------------------------------------------------------------------------------------------------------------------

    private val _GetNetDevices = MutableStateFlow(emptyList<NetDevices>())
    val getNetDevices: StateFlow<List<NetDevices>> get() = _GetNetDevices

    fun getNetDevices() = viewModelScope.launch {
        val response = repository.getNetDevices()
        _GetNetDevices.value = response
    }

    //-------------------------------------------------add new net device ---------------------------------------------------
    private val _AddNetDevice = MutableStateFlow<Resource<String>?>(null)
    val AddNetDeviceResponse: StateFlow<Resource<String>?> = _AddNetDevice

    fun addNetDevice(device: NetDevices) = viewModelScope.launch {
        val response = repository.addNewNetDevice(device)
        _AddNetDevice.value = response
    }

//-------------------------------------------get panne devices------------------------------------------------------

    private val _GetPaneDevices = MutableStateFlow(emptyList<PaneDevices>())
    val getPaneDevices: StateFlow<List<PaneDevices>> get() = _GetPaneDevices

    fun getPaneDevices() = viewModelScope.launch {
        val response = repository.getPaneDevices()
        _GetPaneDevices.value = response
    }


    //---------------------------------------------------add panne devices-----------------------------------------
    private val _AddPanneDevice = MutableStateFlow<Resource<String>?>(null)
    val AddPanneResponse: StateFlow<Resource<String>?> = _AddPanneDevice

    fun addPanneDevice(paneDevices: PaneDevices) = viewModelScope.launch {
        val response = repository.addPanneDevice(paneDevices)
        _AddPanneDevice.value = response
    }

    //---------------------------------------------------------add new hote--------------------------------------------
    private val _AddNewHote = MutableStateFlow<Resource<String>?>(null)
    val addNewHoteResponse: StateFlow<Resource<String>?> = _AddNewHote

    fun AddNewHote(Hote: DirectionDevices) = viewModelScope.launch {
        val response = repository.addNewHote(Hote)
        _AddNewHote.value = response
    }


//---------------------------------------------deleeeeeeeeeeeeeeeeeeeeeeetttt-------------------------------------------
    //-----------------------------------------device------------------------------------------------------------------
    private val _DeleteDeviceState = MutableStateFlow<Resource<String>?>(null)
    val DeleteDeviceState: StateFlow<Resource<String>?> = _DeleteDeviceState


    fun deleteDeviceDep(devices: DirectionDevices) {

        viewModelScope.launch {
            val response = repository.DeleteDeviceDep(devices)
            _DeleteDeviceState.value = response
        }
    }

    //-----------------------------------------Net device------------------------------------------------------------------
    private val _DeleteNetDeviceState = MutableStateFlow<Resource<String>?>(null)
    val DeleteNetDeviceState: StateFlow<Resource<String>?> = _DeleteNetDeviceState


    fun deleteNetDevice(netDevices: NetDevices) {

        viewModelScope.launch {
            val response = repository.DeleteNetDevice(netDevices)
            _DeleteNetDeviceState.value = response
        }
    }

    //-----------------------------------------Net device------------------------------------------------------------------
    private val _DeletePaneDeviceState = MutableStateFlow<Resource<String>?>(null)
    val DeletePaneDeviceState: StateFlow<Resource<String>?> = _DeletePaneDeviceState


    fun deletePaneDevice(deletePane: PaneDelete) {

        viewModelScope.launch {
            val response = repository.DeletePaneDevice(deletePane)
            _DeletePaneDeviceState.value = response
        }
    }

    //-----------------------------------------Net device------------------------------------------------------------------
    private val _DeleteDepState = MutableStateFlow<Resource<String>?>(null)
    val DeleteDepState: StateFlow<Resource<String>?> = _DeleteDepState


    fun deleteDep(Department :String) {

        viewModelScope.launch {
            val response = repository.DeleteDepartment(Department)
            _DeleteDepState.value = response
        }
    }
}