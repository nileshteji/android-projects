package com.osos.squareboatapplication.api

import com.osos.squareboatapplication.R
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object  ApiBuilder {


    fun getInstance():Retrofit{
        return Retrofit.Builder()
            .baseUrl(Constants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create()).build()
    }

    fun getApiCaller():ApiCall{
        return getInstance().create(ApiCall::class.java)
    }


}