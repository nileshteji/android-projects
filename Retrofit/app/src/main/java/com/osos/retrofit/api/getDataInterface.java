package com.osos.retrofit.api;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface getDataInterface {

@GET("/")
    Call<WeatherCast> getWeather(@Query("q") String city,@Query("appid") String appid);


}
