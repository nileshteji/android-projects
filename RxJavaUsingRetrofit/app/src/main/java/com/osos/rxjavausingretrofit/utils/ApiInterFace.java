package com.osos.rxjavausingretrofit.utils;

import com.osos.rxjavausingretrofit.User;

import io.reactivex.rxjava3.core.Observable;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface ApiInterFace {




    @GET("/employee/{id}")
    Observable<User> getSingleEmployee(@Path("id") String id);



}
