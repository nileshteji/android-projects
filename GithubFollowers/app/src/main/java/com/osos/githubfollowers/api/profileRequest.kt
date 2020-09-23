package com.osos.githubfollowers.api

import com.osos.githubfollowers.model.Followers
import com.osos.githubfollowers.model.Profile
import retrofit2.http.GET
import retrofit2.http.Path


public interface profileRequest {

     @GET("/users/{name}")
     suspend fun getName(@Path("name") a:String): Profile


     @GET("/users/{name}/followers")
     suspend fun getFollowers(@Path("name") a:String):ArrayList<Followers>




}