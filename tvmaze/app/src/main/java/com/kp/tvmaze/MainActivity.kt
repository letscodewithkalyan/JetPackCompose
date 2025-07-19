package com.kp.tvmaze

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.activity.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.kp.tvmaze.data.NetworkResponse
import com.kp.tvmaze.viewmodels.MainViewModel
import com.kp.tvmaze.views.DBActivity
import com.kp.tvmaze.views.QuoteActivity
import com.kp.tvmaze.views.adapters.ScheduleAdapter
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    val viewModel: MainViewModel by viewModels()
    lateinit var recyclerView:RecyclerView
    lateinit var scheduleAdapter: ScheduleAdapter
    lateinit var navigateButton: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        recyclerView = findViewById(R.id.showsList)
        recyclerView.layoutManager = LinearLayoutManager(this)
        scheduleAdapter = ScheduleAdapter()
        recyclerView.adapter = scheduleAdapter

        navigateButton = findViewById(R.id.navigateButton)
        navigateButton.setOnClickListener {
            startActivity(Intent(this, QuoteActivity::class.java))
        }

        var dbButton = findViewById<Button>(R.id.dbButton)
        dbButton.setOnClickListener {
            startActivity(Intent(this, DBActivity::class.java))
        }
        bindObservers()
        doSomething(lastName = "Test", firstName = "Kalyan");
    }

    fun bindObservers() {
        lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModel.scheduleShowsList.collect { uiState ->
                    when (uiState) {
                        is NetworkResponse.Success -> {
                            if(uiState.data != null) {
                                scheduleAdapter.updateList(uiState.data)
                            }
                        }
                        is NetworkResponse.Error -> {}
                        is NetworkResponse.Loading -> {}
                    }
                }
            }
        }
    }

    fun doSomething(firstName: String, lastName: String){

    }
}