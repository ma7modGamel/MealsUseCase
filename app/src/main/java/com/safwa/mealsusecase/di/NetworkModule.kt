package com.safwa.mealsusecase.di

import com.example.mylibrary.api.ApiServices
import com.example.mylibrary.api.RetrofitHelper
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    @Provides
    @Singleton
    fun provideApiServices():ApiServices{
        return RetrofitHelper.retrofitInstance.create(ApiServices::class.java)
    }

}