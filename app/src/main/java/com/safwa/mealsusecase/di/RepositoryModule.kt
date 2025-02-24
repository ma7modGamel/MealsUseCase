package com.safwa.mealsusecase.di

import com.example.mylibrary.api.ApiServices
import com.safwa.data.repository.MealsRepositoryImpl
import com.safwa.domain.repository.MealsRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent


@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Provides
    fun provideRepository(apiService: ApiServices): MealsRepository {
        return MealsRepositoryImpl(apiService)
    }
}