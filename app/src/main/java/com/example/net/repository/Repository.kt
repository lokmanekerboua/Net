package com.example.net.repository

import android.util.Log
import com.example.net.data.ApiUser
import com.example.net.data.model.*
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

    suspend fun getDirections(): List<Direction> {
        return apiUser.getAllDirections()
    }

    suspend fun adddirection(direction: Direction): Resource<String> {
        return try {
            val result = apiUser.addDirection(direction)
            Resource.Success(result)
        } catch (ex: Exception) {
            ex.printStackTrace()
            Resource.Error(ex.message.toString())
        }
    }


    suspend fun getDirectionDevices(department: String): List<DirectionDevices> {
        return apiUser.getDirectionDevices(department)
    }

    suspend fun getNetDevices(): List<NetDevices> {
        return apiUser.getNetDevices()
    }

    suspend fun addNewNetDevice(netDevice: NetDevices): Resource<String> {
        return try {
            val result = apiUser.addNewNetDevice(netDevice)
            Resource.Success(result)
        } catch (ex: Exception) {
            ex.printStackTrace()
            Resource.Error(ex.message.toString())
        }
    }

    suspend fun getPaneDevices(): List<PaneDevices> {
        return apiUser.getPaneDevices()
    }

    suspend fun addPanneDevice(paneDevices: PaneDevices): Resource<String> {
        return try {
            val result = apiUser.addPanneDevices(paneDevices)
            Resource.Success(result)
        } catch (ex: Exception) {
            ex.printStackTrace()
            Resource.Error(ex.message.toString())
        }
    }

    suspend fun addNewHote(newHote: DirectionDevices): Resource<String> {
        return try {
            val result = apiUser.addNewHote(newHote)
            Resource.Success(result)
        } catch (ex: Exception) {
            ex.printStackTrace()
            Resource.Error(ex.message.toString())
        }
    }

    //------------------------------------------------delete functions---------------------------------------------
    //------------------------------------------
    suspend fun DeleteDeviceDep(direction: DirectionDevices): Resource<String> {
        return try {
            val result = apiUser.deleteDeviceDep(direction)
            Resource.Success(result)
        } catch (ex: Exception) {
            ex.printStackTrace()
            Resource.Error(ex.message.toString())
        }
    }

    //------------------------------------------
    suspend fun DeleteNetDevice(netDevice: NetDevices): Resource<String> {
        return try {
            val result = apiUser.deleteNetDevice(netDevice)
            Resource.Success(result)
        } catch (ex: Exception) {
            ex.printStackTrace()
            Resource.Error(ex.message.toString())
        }
    }
    //------------------------------------------
    suspend fun DeletePaneDevice(deletePaneDelete: PaneDelete): Resource<String> {
        return try {
            val result = apiUser.deletePaneDevice(deletePaneDelete)
            Resource.Success(result)
        } catch (ex: Exception) {
            ex.printStackTrace()
            Resource.Error(ex.message.toString())
        }
    }
    //------------------------------------------
    suspend fun DeleteDepartment(department: String): Resource<String> {
        return try {
            val result = apiUser.deleteDepartment(department)
            Resource.Success(result)
        } catch (ex: Exception) {
            ex.printStackTrace()
            Resource.Error(ex.message.toString())
        }
    }


}