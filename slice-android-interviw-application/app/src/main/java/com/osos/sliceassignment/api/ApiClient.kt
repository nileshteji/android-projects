package com.osos.sliceassignment.api


import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ApiClient {

    fun getInstance(): Retrofit {
        return Retrofit.Builder()
                .baseUrl(CONSTANTS.url)
                .addConverterFactory(GsonConverterFactory.create())
                .build() //Doesn't require the adapter
    }

    val apiCalls: ApiCalls = getInstance().create(ApiCalls::class.java)

}