package com.kp.tvmaze.viewmodels

import com.kp.tvmaze.MainCoroutineRule
import com.kp.tvmaze.data.NetworkResponse
import com.kp.tvmaze.repository.ScheduleRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.count
import kotlinx.coroutines.flow.toList
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.test.StandardTestDispatcher
import kotlinx.coroutines.test.advanceUntilIdle
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.runTest
import kotlinx.coroutines.test.setMain
import org.junit.Assert.*

import org.junit.After
import org.junit.Assert
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.MockitoAnnotations

class ScheduleViewModelTest {

    @get:Rule
    val mainCoroutineRule = MainCoroutineRule()

    @Mock
    lateinit var scheduleRepository: ScheduleRepository

    private lateinit var viewModel: ScheduleViewModel

    @Before
    fun setUp() {
        MockitoAnnotations.openMocks(this)
        viewModel = ScheduleViewModel(scheduleRepository)
    }

    @Test
    fun test_loadItems() = runTest {
        //Arrange
        Mockito.`when`(scheduleRepository.getScheduleList())
            .thenReturn(NetworkResponse.Success(emptyList()))
        //Act
        viewModel.loadItems()
        advanceUntilIdle()
        //Assert
        Assert.assertEquals(viewModel.scheduleList.value.data!!.size, 0)
    }

    @After
    fun tearDown() {
    }
}