package com.kp.tvmaze.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.kp.tvmaze.Constants
import com.kp.tvmaze.data.api.ScheduleApi
import com.kp.tvmaze.repository.MainRepository
import com.kp.tvmaze.repository.ScheduleRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(val mainRepository: MainRepository) : ViewModel() {
    val scheduleShowsList get() = mainRepository.scheduleList
    init {
        viewModelScope.launch {
            mainRepository.getScheduleList()
        }
    }
}