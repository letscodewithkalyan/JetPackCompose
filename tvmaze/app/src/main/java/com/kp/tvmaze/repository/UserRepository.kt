package com.kp.tvmaze.repository

import com.kp.tvmaze.data.db.User
import com.kp.tvmaze.data.db.UserDao
import java.util.concurrent.Flow
import javax.inject.Inject

class UserRepository @Inject constructor(val userDao: UserDao) {
    fun insertUser(user: User){
        return userDao.insertAll(user)
    }

    fun getUsers(): kotlinx.coroutines.flow.Flow<List<User>>{
        return userDao.getAll()
    }
}