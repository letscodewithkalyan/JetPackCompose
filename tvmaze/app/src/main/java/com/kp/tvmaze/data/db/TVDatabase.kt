package com.kp.tvmaze.data.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject

@Database(entities = [User::class], version = 1)
abstract class TVDatabase : RoomDatabase(){
    abstract fun userDao() : UserDao
}