package com.example.mylibrary.api


import retrofit2.http.GET

interface ApiServices {

    @GET("categories.php")
    fun getMeals() : CategoryResponse
}