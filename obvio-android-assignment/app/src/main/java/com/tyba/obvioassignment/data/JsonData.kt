package com.tyba.obvioassignment.data

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class JsonData(
    var date: String?,
    var explanation: String?,
    var title: String?,
    var url: String?,
    var copyright: String,
    var bookMark:Boolean = false
) : Parcelable


