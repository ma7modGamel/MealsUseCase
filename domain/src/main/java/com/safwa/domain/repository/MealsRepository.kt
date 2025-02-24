package com.safwa.domain.repository

import com.safwa.domain.models.CategoryResponse

interface MealsRepository {
    fun getMealsFromApi() : CategoryResponse
}