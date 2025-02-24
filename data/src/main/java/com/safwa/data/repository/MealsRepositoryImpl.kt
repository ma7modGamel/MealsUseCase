package com.safwa.data.repository

import com.example.mylibrary.api.ApiServices
import com.safwa.domain.models.CategoryResponse
import com.safwa.domain.repository.MealsRepository

class MealsRepositoryImpl(private var apiService: ApiServices) : MealsRepository  {
    override fun getMealsFromApi(): CategoryResponse {
        return apiService.getMeals()
    }
}