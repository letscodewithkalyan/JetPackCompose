package com.kp.tvmaze.views

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.activity.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.textfield.TextInputEditText
import com.kp.tvmaze.R
import com.kp.tvmaze.viewmodels.DBViewModel
import com.kp.tvmaze.views.adapters.UserAdapter
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

@AndroidEntryPoint
class DBActivity : AppCompatActivity() {
    val viewModel:DBViewModel by viewModels()
    lateinit var userAdapter: UserAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_db)
        var firstNameEditText = findViewById<TextInputEditText>(R.id.firstNameEditText)
        var lastNameEditText = findViewById<TextInputEditText>(R.id.lastNameEditText);
        var submitButton = findViewById<Button>(R.id.submitButton)
        submitButton.setOnClickListener {
            viewModel.insertUser(firstNameEditText.text.toString(), lastNameEditText.text.toString())
        }
        val recyclerView = findViewById<RecyclerView>(R.id.usersList)
        recyclerView.layoutManager = LinearLayoutManager(this);
        userAdapter = UserAdapter()
        recyclerView.adapter = userAdapter
        bindObservers()
    }

    fun bindObservers(){
        lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED){
                viewModel.users.collect { it ->
                    userAdapter.updateList(it)
                }
            }
        }
    }
}