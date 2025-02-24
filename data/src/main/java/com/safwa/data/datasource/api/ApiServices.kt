package com.example.mylibrary.api

import com.safwa.domain.models.CategoryResponse
import retrofit2.http.GET

interface ApiServices {

    @GET("categories.php")
    fun getMeals() : CategoryResponse
}