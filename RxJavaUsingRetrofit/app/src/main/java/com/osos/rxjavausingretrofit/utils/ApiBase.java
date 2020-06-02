package com.osos.rxjavausingretrofit.utils;

import hu.akarnokd.rxjava3.retrofit.RxJava3CallAdapterFactory;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiBase {

   Retrofit INSTANCE;

    public Retrofit getRetrofit(){
            if(INSTANCE==null){
                INSTANCE=new Retrofit.Builder().baseUrl("https://jsonplaceholder.typicode.com/").
                        addConverterFactory(GsonConverterFactory.create())
                        .addCallAdapterFactory(RxJava3CallAdapterFactory.create()).build();
            }


        return INSTANCE;
    }


}
