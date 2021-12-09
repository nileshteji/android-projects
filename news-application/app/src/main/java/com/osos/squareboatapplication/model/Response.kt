package com.osos.squareboatapplication.model

import com.google.gson.annotations.SerializedName


data class Response(

    var status:String,
    @SerializedName("totalResults")
    var size:Int,
    var articles:List<Article>
)