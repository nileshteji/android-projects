package com.osos.sliceassignment.api

import com.osos.sliceassignment.model.Response

import retrofit2.http.GET

interface ApiCalls {

    @GET("/tweets")
    suspend fun getTweets():Response
}