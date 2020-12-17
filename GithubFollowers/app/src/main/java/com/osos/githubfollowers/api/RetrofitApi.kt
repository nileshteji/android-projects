package com.osos.githubfollowers.api

import com.osos.githubfollowers.Constants
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitApi {


    fun getInstance(): Retrofit {
        return Retrofit.Builder().addConverterFactory(GsonConverterFactory.create())
            .baseUrl(Constants.baseUrl).build()

    }

}