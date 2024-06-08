package com.kp.mytweet.data.api

import com.kp.mytweet.data.dto.ShowDto
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface ShowsAPI {
    @GET("/shows")
    suspend fun getShows() : Response<List<ShowDto>>

    @GET("/shows/{id}")
    suspend fun getShowDetails(@Path("id") showId:Int): Response<ShowDto>
}