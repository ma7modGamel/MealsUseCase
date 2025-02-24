package com.safwa.domain.repository

import com.safwa.domain.models.CategoryResponse

interface MealsRepository {
   suspend fun getMealsFromApi() : CategoryResponse
}