package com.example.net.di

import com.example.net.data.ApiUser
import com.example.net.utils.Constants.Companion.BASE_URL
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object ApiModule {
    var gson = GsonBuilder().setLenient().create()

    @Provides
    @Singleton
    fun provideApi(builder: Retrofit.Builder): ApiUser {
        return builder.build().create(ApiUser::class.java)
    }

    @Provides
    @Singleton
    fun provideRetrofit(): Retrofit.Builder {
        return Retrofit.Builder().baseUrl(BASE_URL).addConverterFactory(
            GsonConverterFactory.create(
                gson
            )
        )
    }
}