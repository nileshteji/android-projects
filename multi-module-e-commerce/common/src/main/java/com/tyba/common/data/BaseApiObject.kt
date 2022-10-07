package com.tyba.common.data

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.ExclusionStrategy
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize


data class BaseApiObject(
    var features: List<Feature>,
    var exclusions: List<List<Exclusion>>
)

@Entity(tableName = "feature")
data class Feature(
    @PrimaryKey @SerializedName("feature_id") var id: String,
    var name: String,
    var options: List<Option>,
    var expanded:Boolean = false
)

@Parcelize
@Entity(tableName = "option")
data class Option(
    @PrimaryKey var id: String,
    var name: String,
    var icon: String
):Parcelable

@Entity(tableName = "exclusions")
data class ExclusionBaseObject(
    @PrimaryKey(autoGenerate = true) var id:Int,
    var list: List<Exclusion>
)


data class Exclusion(
     var feature_id: String,
     var options_id:String
)


