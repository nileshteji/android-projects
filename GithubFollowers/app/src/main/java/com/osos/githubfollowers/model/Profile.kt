package com.osos.githubfollowers.model

import com.google.gson.annotations.SerializedName

data class Profile(@SerializedName("name") val name:String,
                   @SerializedName("company") val company:String,
                   @SerializedName("avatar_url") val avatar_url:String,
                   @SerializedName("bio") val bio:String,
                   )
