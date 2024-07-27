package com.kp.tvmaze.api

import com.kp.tvmaze.Helper
import com.kp.tvmaze.data.api.ScheduleApi
import kotlinx.coroutines.test.runTest
import okhttp3.mockwebserver.MockResponse
import okhttp3.mockwebserver.MockWebServer
import org.junit.After
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ScheduleApiTest {
    lateinit var mockWebServer: MockWebServer
    lateinit var scheduleApi: ScheduleApi

    @Before
    fun setUp() {
        mockWebServer = MockWebServer()
        scheduleApi = Retrofit.Builder()
            .baseUrl(mockWebServer.url("/"))
            .addConverterFactory(GsonConverterFactory.create())
            .build().create(ScheduleApi::class.java)
    }

    @Test
    fun testGetScheduleApi() = runTest {
        val mockResponse = MockResponse()
        mockResponse.setBody("[]")
        mockWebServer.enqueue(mockResponse)

        val response = scheduleApi.getScheduleShows()
        mockWebServer.takeRequest()

        Assert.assertEquals(true, response.body()!!.isEmpty())
    }

    //Takes response response file in resources folder
    //Which are same in open we kept for  mocking
    //I tried in the same file showing some error.
    @Test
    fun testGetScheduleApi_GetList() = runTest {
        val mockResponse = MockResponse()
        val content = Helper.readFileResource("/response.json")
        mockResponse.setBody(content)
        mockResponse.setResponseCode(200)
        mockWebServer.enqueue(mockResponse)

        val response = scheduleApi.getScheduleShows()
        mockWebServer.takeRequest()

        Assert.assertEquals(2, response.body()!!.size)
    }

    @After
    fun tearDown() {
        mockWebServer.shutdown()
    }

}