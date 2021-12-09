package com.osos.appdeskservice.api

import android.nfc.Tag
import android.util.Log
import okhttp3.Interceptor
import okhttp3.Request
import okhttp3.Response

class NetworkInterceptor : Interceptor {

    val Tag ="Interceptor"
    override fun intercept(chain: Interceptor.Chain): Response {

        val request: Request = chain.request()

        val t1 = System.nanoTime()

        Log.i(Tag, String.format("Sending request %s on %s%n%s",
            request.url(), chain.connection(), request.headers()))

        val response : Response = chain.proceed(request)


        val t2 = System.nanoTime()

        Log.i(Tag, String.format(
            "Received response for %s in %.1fms%n%s",
            response.request().url(), (t2 - t1) / 1e6, response.headers()
        ))


        return response
    }
}