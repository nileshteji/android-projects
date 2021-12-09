package com.osos.squareboatapplication.model

import android.net.Uri
import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize
import java.io.Serializable


//used serializable because tp reduce code.Efficiency is still not good
@Parcelize
data class Article(
    var source: Source?,
    var author:String?,
    var title:String?,
    var description:String?,
    var url:String?,
    @SerializedName("urlToImage")
    var image:String?,
    @SerializedName("publishedAt")
    var date:String?,
    var content:String?
):Parcelable