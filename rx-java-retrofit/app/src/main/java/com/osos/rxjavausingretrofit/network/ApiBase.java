package com.osos.rxjavausingretrofit.network;

import hu.akarnokd.rxjava3.retrofit.RxJava3CallAdapterFactory;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public  class ApiBase {

   static Retrofit INSTANCE;

    public static  Retrofit getRetrofit(){
            if(INSTANCE==null){
                INSTANCE=new Retrofit.Builder().baseUrl("https://jsonplaceholder.typicode.com/").
                        addConverterFactory(GsonConverterFactory.create())
                        .addCallAdapterFactory(RxJava3CallAdapterFactory.create()).build();
            }


        return INSTANCE;
    }


}
