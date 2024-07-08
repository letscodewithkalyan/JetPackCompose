package com.kp.tvmaze.views

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.kp.tvmaze.R
import com.kp.tvmaze.data.NetworkResponse
import com.kp.tvmaze.viewmodels.ScheduleViewModel
import com.kp.tvmaze.views.adapters.ScheduleAdapter
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

class ScheduleActivity : AppCompatActivity() {
    val viewModel: ScheduleViewModel by viewModels()
    lateinit var recyclerView: RecyclerView
    lateinit var scheduleAdapter: ScheduleAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_schedule)
        recyclerView = findViewById(R.id.showsList)
        recyclerView.layoutManager = LinearLayoutManager(this)
        scheduleAdapter = ScheduleAdapter()
        recyclerView.adapter = scheduleAdapter

        bindObservers()
    }

    fun bindObservers() {
        lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModel.scheduleList.collect { uiState ->
                    when (uiState) {
                        is NetworkResponse.Error -> {}
                        is NetworkResponse.Loading -> {}
                        is NetworkResponse.Success -> {
                            if(uiState.data != null) {
                                scheduleAdapter.updateList(uiState.data)
                            }
                        }
                    }
                }
            }
        }
    }
}