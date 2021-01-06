package com.osos.roomapi

sealed class Result{

    data class Success(val a : String): Result()
    data class Error(val b : String): Result();

}
