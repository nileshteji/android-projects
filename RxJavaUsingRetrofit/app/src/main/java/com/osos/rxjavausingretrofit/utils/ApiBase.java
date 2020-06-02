package com.osos.rxjavausingretrofit.utils;

import hu.akarnokd.rxjava3.retrofit.RxJava3CallAdapterFactory;
import io.reactivex.rxjava3.internal.schedulers.RxThreadFactory;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiBase {

   private Retrofit INSTANCE;

    public Retrofit getRetrofit(){
            if(INSTANCE==null){
                INSTANCE=new Retrofit.Builder().baseUrl("http://dummy.restapiexample.com/api/v1")
                        .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
                        .addConverterFactory(GsonConverterFactory.create()).build();
            }


        return null;
    }


}
