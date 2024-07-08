package com.kp.tvmaze.repository

import com.kp.tvmaze.data.NetworkResponse
import com.kp.tvmaze.data.api.ScheduleApi
import com.kp.tvmaze.data.dto.Schedule
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import retrofit2.Response
import javax.inject.Inject

class ScheduleRepository @Inject constructor(val scheduleApi: ScheduleApi) {
    suspend fun getScheduleList() : NetworkResponse<List<Schedule>> {
        var response = scheduleApi.getScheduleShows()
        if(response.isSuccessful && response.body() != null){
            return NetworkResponse.Success(response.body()!!)
        }
        return  NetworkResponse.Error( null,"Something went wrong")
    }
}