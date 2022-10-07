package com.osos.sliceassignment.model

import com.google.gson.annotations.SerializedName

data class Tweets(val name:String,
                  val handle:String,
                  @SerializedName("favoriteCount")val like:Int,
                  @SerializedName("retweetCount") val retweet:Int,
                  @SerializedName("profileImageUrl") val image:String,
                  val text:String
                  )