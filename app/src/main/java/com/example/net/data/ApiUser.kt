package com.example.net.data

import com.example.net.data.model.*
import com.example.net.utils.Constants.Companion.ADD_NEW_DEVICES_URL
import com.example.net.utils.Constants.Companion.DELETE_DEVICE_DEP
import com.example.net.utils.Constants.Companion.DEL_DIRECTIONS_URL
import com.example.net.utils.Constants.Companion.DIRECTIONS_DEVICES_URL
import com.example.net.utils.Constants.Companion.DIRECTIONS_URL
import com.example.net.utils.Constants.Companion.NET_DEVICES_URL
import com.example.net.utils.Constants.Companion.PANE_DEVICES_URL
import com.example.net.utils.Constants.Companion.USERS_URL
import com.example.net.utils.Resource
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.HTTP
import retrofit2.http.POST
import retrofit2.http.Path
import retrofit2.http.Query
import com.example.net.data.model.DirectionDevices as DirectionDevices1

interface ApiUser {
    @POST(USERS_URL)
    suspend fun addUser(@Body user: UserRes): String

    @POST("users/log")
    suspend fun logUser(
        @Query("username") username: String,
        @Query("password") password: String,
    ): String

    @GET(DIRECTIONS_URL)
    suspend fun getAllDirections(): List<Direction>

    @POST(DIRECTIONS_URL)
    suspend fun addDirection(@Body dirction: Direction): String

    @GET(DIRECTIONS_DEVICES_URL + "{department}")
    suspend fun getDirectionDevices(@Path("department") department: String): List<DirectionDevices1>

    @GET(NET_DEVICES_URL)
    suspend fun getNetDevices(): List<NetDevices>

    @POST(NET_DEVICES_URL)
    suspend fun addNewNetDevice(@Body netdevice: NetDevices): String

    @GET(PANE_DEVICES_URL)
    suspend fun getPaneDevices(): List<PaneDevices>

    @POST(PANE_DEVICES_URL)
    suspend fun addPanneDevices(@Body paneDevices: PaneDevices): String

    @POST(ADD_NEW_DEVICES_URL)
    suspend fun addNewHote(@Body device: DirectionDevices1): String

    @HTTP(method = "DELETE", path = DELETE_DEVICE_DEP, hasBody = true)
    suspend fun deleteDeviceDep(@Body directionDevices: DirectionDevices1): String

    @HTTP(method = "DELETE", path = NET_DEVICES_URL, hasBody = true)
    suspend fun deleteNetDevice(@Body netdevice: NetDevices): String

    @HTTP(method = "DELETE", path = PANE_DEVICES_URL, hasBody = true)
    suspend fun deletePaneDevice(@Body deletePane: PaneDelete): String

    @HTTP(method = "DELETE", path = DEL_DIRECTIONS_URL + "{department}", hasBody = true)
    suspend fun deleteDepartment(@Path("department") department: String): String
}