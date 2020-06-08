package com.osos.paginglibrary.api;

import com.osos.paginglibrary.model.Details;

import java.util.List;

import io.reactivex.rxjava3.core.Flowable;
import retrofit2.http.GET;

public interface ApiInterface {


    @GET("todos")
    Flowable<List<Details>> getSingleEmployee();


}
