package com.safwa.data.repository

import android.util.Log
import com.google.gson.Gson
import com.safwa.data.datasource.api.ApiServices
import com.safwa.domain.models.CategoryResponse
import com.safwa.domain.repository.MealsRepository

class MealsRepositoryImpl(private var apiService: ApiServices) : MealsRepository  {
    override suspend fun getMealsFromApi(): CategoryResponse {
        Log.e("yyy", Gson().toJson(apiService.getMeals()))
        return apiService.getMeals()
    }
}