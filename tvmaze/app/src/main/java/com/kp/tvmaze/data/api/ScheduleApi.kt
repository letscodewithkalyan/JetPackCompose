package com.kp.tvmaze.data.api

import com.kp.tvmaze.data.dto.Schedule
import retrofit2.Response
import retrofit2.http.GET

interface ScheduleApi {
    @GET("schedule?country=US&date=2014-12-01")
    suspend fun getScheduleShows():Response<List<Schedule>>
}