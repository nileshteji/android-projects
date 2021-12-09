package com.osos.appdeskservice.api

import com.osos.appdeskservice.data.DateResponse
import com.osos.appdeskservice.data.Response
import com.osos.appdeskservice.data.SevenDayResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiCall {

//    api.openweathermap.org/data/2.5/weather?lat={lat}&lon={lon}&appid={API key}


    @GET("data/2.5/weather")

    suspend fun getWeather(

      @Query("lat") lat: String,
      @Query("lon") lon: String,
      @Query("appid") key: String,
      @Query("units") unit: String

    ): Response


    @GET("data/2.5/onecall")

    suspend fun sevenDayWeather(

        @Query("lat") lat: String,
        @Query("lon") lon: String,
        @Query("appid") key: String,
        @Query("units") unit: String

    ) :SevenDayResponse


//    https://api.openweathermap.org/data/2.5/onecall/timemachine?lat=19.076&lon=72.8777&dt=1605637800&appid=52e3ab36dcce75b35b8133454ef2fdbd

    @GET("data/2.5/onecall/timemachine")
    suspend fun getHistory(

        @Query("lat") lat: String,
        @Query("lon") lon: String,
        @Query("dt") dt:String,
        @Query("appid") key: String,
        @Query("units") unit: String

    ) : DateResponse


}


