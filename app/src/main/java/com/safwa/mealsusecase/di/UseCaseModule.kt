package com.safwa.mealsusecase.di

import com.safwa.domain.repository.MealsRepository
import com.safwa.domain.usecase.GetMealsUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent


@Module
@InstallIn(SingletonComponent::class)
object UseCaseModule {


    @Provides

    fun provideUseCase(mealsRepository: MealsRepository): GetMealsUseCase {
        return GetMealsUseCase(mealsRepository)
    }

}