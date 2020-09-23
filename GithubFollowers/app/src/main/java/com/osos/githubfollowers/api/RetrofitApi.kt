package com.osos.githubfollowers.api

import com.osos.githubfollowers.Constants
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

abstract class RetrofitApi{



    companion object{
        fun getInstance(): Retrofit {
            return Retrofit.Builder().addConverterFactory(GsonConverterFactory.create())
                .baseUrl(Constants.baseUrl).build()
        }
    }




}