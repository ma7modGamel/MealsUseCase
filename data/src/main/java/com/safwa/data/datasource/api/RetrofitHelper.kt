package com.example.mylibrary.api


import com.google.gson.FieldNamingPolicy
import com.google.gson.GsonBuilder

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.converter.scalars.ScalarsConverterFactory
import java.util.concurrent.TimeUnit

object RetrofitHelper   {
//    private val loggingInterceptor = HttpLoggingInterceptor().apply {
//        level = HttpLoggingInterceptor.Level.BODY
//    }

    private val gson = GsonBuilder()
        .setDateFormat("yyyy-MM-dd")
        .setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES)
        .setLenient()
        .create()


    private val okHttpClient = OkHttpClient.Builder()
        //.addInterceptor(loggingInterceptor)
        .addInterceptor { chain ->
            val requestBuilder = chain.request().newBuilder()
            requestBuilder.header("Accept", "application/json")
            requestBuilder.header("Platform", "Android")
            chain.proceed(requestBuilder.build())
        }
       // .addInterceptor(ChuckerInterceptor(MyApp.context))
        .connectTimeout(120, TimeUnit.SECONDS)
        .writeTimeout(120, TimeUnit.SECONDS)
        .readTimeout(120, TimeUnit.SECONDS)
        .build()



    val retrofitInstance: Retrofit by lazy {
        Retrofit.Builder()
            .client(okHttpClient)
            .baseUrl(RetrofitConstant.URL)
            .addConverterFactory(ScalarsConverterFactory.create())
            .addConverterFactory(GsonConverterFactory.create(gson))
           // .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
            .build()
    }
}