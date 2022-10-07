package com.tyba.api

import com.tyba.common.data.BaseApiObject
import io.reactivex.rxjava3.core.Flowable
import retrofit2.http.GET

interface ApiCalls{
    @GET("mhrpatel12/esper-assignment/db")
    fun getRemoteData() : Flowable<BaseApiObject>


}