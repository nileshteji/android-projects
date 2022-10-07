package com.tyba.repository.convertors

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.tyba.common.data.Exclusion
import com.tyba.common.data.Option

class RoomConvertors {
    @TypeConverter
    fun listToString(value:List<Option>):String {
        val gsonObject = Gson()
        return gsonObject.toJson(value)
    }

    @TypeConverter
    fun StringToList(value:String):List<Option>{
        var typeObject = object : TypeToken<List<Option>>() {}.type
       return Gson().fromJson(value,typeObject)
    }



    @TypeConverter
    fun exclusionListToString(value:List<Exclusion>):String {
        val gsonObject = Gson()
        return gsonObject.toJson(value)
    }

    @TypeConverter
    fun StringToExclusion(value:String):List<Exclusion>{
        var typeObject = object : TypeToken<List<Exclusion>>() {}.type
        return Gson().fromJson(value,typeObject)
    }
}