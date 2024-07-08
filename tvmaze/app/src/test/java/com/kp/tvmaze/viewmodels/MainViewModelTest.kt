package com.kp.tvmaze.viewmodels
import com.kp.tvmaze.data.NetworkResponse
import com.kp.tvmaze.repository.MainRepository
import com.kp.tvmaze.repository.ScheduleRepository
import kotlinx.coroutines.test.StandardTestDispatcher
import kotlinx.coroutines.test.runTest
import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.MockitoAnnotations

class MainViewModelTest {

    private val testDispatcher = StandardTestDispatcher()

    @Mock
    lateinit var mainRepository: MainRepository

    @Before
    fun setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    fun test_GetScheduleList() = runTest{
        Mockito.`when`(mainRepository.getScheduleList())
    }
}