package com.kp.mytweet.di

import com.kp.mytweet.data.api.ShowsAPI
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class NetworkModule {
    @Provides
    @Singleton
    fun providesRetroFit() : Retrofit {
        return Retrofit.Builder().baseUrl("https://api.tvmaze.com")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Provides
    @Singleton
    fun provideShowsAPI(retrofit: Retrofit): ShowsAPI{
        return retrofit.create(ShowsAPI::class.java)
    }
}