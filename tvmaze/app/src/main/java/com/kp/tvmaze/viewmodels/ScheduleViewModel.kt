package com.kp.tvmaze.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.kp.tvmaze.data.NetworkResponse
import com.kp.tvmaze.data.dto.Schedule
import com.kp.tvmaze.repository.ScheduleRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

class ScheduleViewModel @Inject constructor(val scheduleRepository: ScheduleRepository) : ViewModel() {
    private val _scheduleList  = MutableStateFlow<NetworkResponse<List<Schedule>>>(NetworkResponse.Loading())
    val scheduleList: StateFlow<NetworkResponse<List<Schedule>>>
        get() = _scheduleList
    init {
        loadItems()
    }

    fun loadItems(){
        viewModelScope.launch {
            _scheduleList.emit(NetworkResponse.Loading())
            var response = scheduleRepository.getScheduleList()
            _scheduleList.emit(response)
        }
    }

}