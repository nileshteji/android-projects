

package com.osos.rxjavausingretrofit.network;

import com.osos.rxjavausingretrofit.User;

import io.reactivex.rxjava3.core.Flowable;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface ApiInterFace {


    @GET("todos/{id}")
    Flowable<User> getSingleEmployee(@Path("id") Integer id);


}
