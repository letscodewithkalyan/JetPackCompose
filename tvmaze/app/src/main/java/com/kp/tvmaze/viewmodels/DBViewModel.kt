package com.kp.tvmaze.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.kp.tvmaze.data.db.User
import com.kp.tvmaze.repository.UserRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject
import kotlin.coroutines.CoroutineContext
import kotlin.random.Random

@HiltViewModel
class DBViewModel @Inject constructor(val userRepository: UserRepository) : ViewModel() {
    val _users = MutableStateFlow<List<User>>(emptyList())
    val users: StateFlow<List<User>>
        get() = _users

    private val viewModelScope = CoroutineScope(Dispatchers.IO)

    init {
        loadItems()
    }

    fun loadItems(){
        viewModelScope.launch {
            userRepository.userDao.getAll().collect {
                _users.emit(it)
            }
        }
    }

    fun insertUser(firstName:String , lastName:String){
        viewModelScope.launch {
            userRepository.userDao.insertAll(User(Math.random(), firstName, lastName))
        }
    }

}