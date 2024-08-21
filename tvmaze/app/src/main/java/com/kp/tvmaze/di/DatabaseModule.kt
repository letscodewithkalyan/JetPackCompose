package com.kp.tvmaze.di

import android.content.Context
import androidx.room.Room
import com.kp.tvmaze.data.db.TVDatabase
import com.kp.tvmaze.data.db.UserDao
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.android.scopes.ActivityScoped
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
class DatabaseModule {
    @Provides
    @Singleton
    fun provideUserDao(tvDatabase: TVDatabase): UserDao {
        return tvDatabase.userDao()
    }

    @Provides
    @Singleton
    fun provideTVDatabase(@ApplicationContext applicationContext: Context): TVDatabase {
        return Room.databaseBuilder(applicationContext, TVDatabase::class.java, "tvmaze_database")
            .build()
    }
}