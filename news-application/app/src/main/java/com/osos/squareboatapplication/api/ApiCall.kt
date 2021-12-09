package com.osos.squareboatapplication.api

import com.osos.squareboatapplication.model.Response
import com.osos.squareboatapplication.model.SORT
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiCall {


    @GET("top-headlines")
    suspend fun default(
        @Query("country") country:String,
        @Query("apiKey") apiKey:String,
        @Query("page") page: Int = 1,
        @Query("pageSize") pageSize: Int = 30
    ):Response


    @GET("top-headlines")
    suspend fun sortSources(
        @Query("sources") sources:List<String>,
        @Query("apiKey") apiKey: String,
        @Query("page") page: Int =1,
        @Query("pageSize") pageSize: Int =30
    ):Response



    @GET("everything")
    suspend fun querySearch(
        @Query("q") query: String,
        @Query("apiKey") apiKey: String,
        @Query("page") page: Int = 1,
        @Query("pageSize") pageSize: Int = 30
    ):Response



    @GET(value = "everything")
    suspend fun sort(
        @Query("q") query: String,
        @Query("sortBy") a:String,
        @Query("apiKey") apiKey: String,
        @Query("page") page: Int = 1,
        @Query("pageSize") pageSize: Int = 30
    ):Response




}