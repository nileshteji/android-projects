package com.osos.rxjavausingretrofit.utils;

import android.content.Intent;

import com.osos.rxjavausingretrofit.User;

import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.Single;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface ApiInterFace {




    @GET("todos/{id}")
    Flowable<User> getSingleEmployee(@Path("id") Integer id);



    





}
