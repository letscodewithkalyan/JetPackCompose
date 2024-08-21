package com.kp.tvmaze.di

import android.content.Context
import com.kp.tvmaze.Constants
import com.kp.tvmaze.data.api.ScheduleApi
import com.kp.tvmaze.repository.UserRepository
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import dagger.hilt.android.qualifiers.ActivityContext
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.Retrofit.Builder
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
class NetworkModule {
    @Singleton
    @Provides
    fun provideRetrofit(): Retrofit.Builder {
        return Retrofit.Builder().baseUrl(Constants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
    }

    @Singleton
    @Provides
    fun provideScheduleApi(retrofitBuilder: Builder): ScheduleApi {
        return retrofitBuilder.build().create(ScheduleApi::class.java)
    }
}

@InstallIn(ActivityComponent::class)
@Module
abstract class Repository {
    @Binds
    abstract fun provideUser(userRepository: UserRepository): UserRepository
}

class MyRepo(@ApplicationContext appContext: Context, @ActivityContext activtyContext: Context){
}