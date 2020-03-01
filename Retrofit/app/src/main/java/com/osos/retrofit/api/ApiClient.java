package com.osos.retrofit.api;

import java.util.List;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;

public class ApiClient
{
public static final String BASE_URl="http://api.openweathermap.org/";
public static Retrofit retrofit = null;
public static  Retrofit getRetrofit(){
    if(retrofit==null){
        retrofit= new Retrofit.Builder().baseUrl(BASE_URl).addConverterFactory(GsonConverterFactory.create()).build();
    }
    return retrofit;
}


}


