package com.safwa.data.datasource.api

import com.safwa.domain.models.CategoryResponse
import retrofit2.http.GET

interface ApiServices {

    @GET("categories.php")
    suspend fun getMeals() : CategoryResponse
}
