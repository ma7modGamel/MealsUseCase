package com.safwa.mealsusecase.di


import com.google.gson.FieldNamingPolicy
import com.google.gson.GsonBuilder
import com.safwa.data.datasource.api.ApiServices
import com.safwa.data.datasource.api.RetrofitConstant
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.converter.scalars.ScalarsConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {



    @Provides
    @Singleton
    fun provideApiServices(retrofit: Retrofit):ApiServices{
        return retrofit.create(ApiServices::class.java)
    }


    @Provides
    @Singleton
    fun provideOkHttpClient(): OkHttpClient  =OkHttpClient.Builder()
        .addInterceptor(
            HttpLoggingInterceptor().apply {
                level = HttpLoggingInterceptor.Level.BODY
            }
        )
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



    @Provides
    @Singleton
    fun provideRetrofit( okHttpClient: OkHttpClient): Retrofit = Retrofit.Builder()
            .client(okHttpClient)
            .baseUrl(RetrofitConstant.URL)
            .addConverterFactory(ScalarsConverterFactory.create())
            .addConverterFactory(GsonConverterFactory.create(GsonBuilder()
                .setDateFormat("yyyy-MM-dd")
                .setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES)
                .setLenient()
                .create()
            ))
            // .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
            .build()

}