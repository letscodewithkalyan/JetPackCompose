package com.kp.tvmaze

import android.app.Application
import com.kp.tvmaze.data.api.ScheduleApi
import dagger.hilt.android.HiltAndroidApp
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltAndroidApp
class TVMazeApplication : Application(){
    @Inject
    lateinit var scheduleApi: ScheduleApi
    override fun onCreate() {
        super.onCreate()
        CoroutineScope(Dispatchers.IO).launch {
            scheduleApi.getScheduleShows()
        }
    }
}