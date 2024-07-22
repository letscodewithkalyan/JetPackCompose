package com.kp.tvmaze.repository

import com.kp.tvmaze.data.NetworkResponse
import com.kp.tvmaze.data.api.ScheduleApi
import kotlinx.coroutines.test.runTest
import okhttp3.ResponseBody
import okhttp3.ResponseBody.Companion.toResponseBody
import org.junit.Assert.*

import org.junit.After
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.MockitoAnnotations
import retrofit2.Response

class ScheduleRepositoryTest {

    @Mock
    lateinit var scheduleApi: ScheduleApi

    @Before
    fun setUp() {
        MockitoAnnotations.openMocks(this)
    }

    @Test
    fun test_getScheduleList_successEmptyList() = runTest {
        //Arrange
        Mockito.`when`(scheduleApi.getScheduleShows()).thenReturn(Response.success(emptyList()))
        //Act
        var repository = ScheduleRepository(scheduleApi)
        var response = repository.getScheduleList()
        //Assert
        Assert.assertEquals(response.data!!.size, 0)
        Assert.assertEquals(true, response is NetworkResponse.Success)
    }

    @Test
    fun test_getScheduleList_error() = runTest {
        //Arrange
        Mockito.`when`(scheduleApi.getScheduleShows())
            .thenReturn(Response.error(401, "UnAuthorized".toResponseBody()))
        //Act
        var repository = ScheduleRepository(scheduleApi)
        var response = repository.getScheduleList()
        //Assert
        Assert.assertEquals("Something went wrong", response.message)
    }

    @After
    fun tearDown() {
    }
}