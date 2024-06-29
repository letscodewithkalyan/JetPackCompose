package com.kp.tvmaze

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import com.kp.tvmaze.data.NetworkResponse
import com.kp.tvmaze.viewmodels.MainViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    val viewModel: MainViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        bindObservers()
    }

    fun bindObservers() {
        lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModel.scheduleShowsList.collect { uiState ->
                    when (uiState) {
                        is NetworkResponse.Success -> {
                            println(uiState.data)
                        }
                        is NetworkResponse.Error -> {}
                        is NetworkResponse.Loading -> {}
                    }
                }
            }
        }
    }
}