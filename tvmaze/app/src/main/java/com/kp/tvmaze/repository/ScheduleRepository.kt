package com.kp.tvmaze.repository

import com.kp.tvmaze.data.NetworkResponse
import com.kp.tvmaze.data.api.ScheduleApi
import com.kp.tvmaze.data.dto.Schedule
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject

class ScheduleRepository @Inject constructor(val scheduleApi: ScheduleApi) {
    private val _scheduleList  = MutableStateFlow<NetworkResponse<List<Schedule>>>(NetworkResponse.Loading())
    val scheduleList:StateFlow<NetworkResponse<List<Schedule>>>
        get() = _scheduleList

    suspend fun getScheduleList(){
        _scheduleList.emit(NetworkResponse.Loading())
        var response = scheduleApi.getScheduleShows()
        if(response.isSuccessful && response.body() != null){
            _scheduleList.emit(NetworkResponse.Success(response.body()!!))
        }
    }
}