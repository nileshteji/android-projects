package com.tyba.obvioassignment.datasource

import android.app.Application
import android.content.Context
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.tyba.obvioassignment.data.JsonData

class JsonDataSource constructor(var _application: Context) {

    private fun loadJson(): String? {

        var json: String? = null;

        try {
            val inputStream = _application.assets.open("data.json")
            val size: Int = inputStream.available()
            val buffer = ByteArray(size)
            inputStream.read(buffer)
            inputStream.close()
            json = String(buffer)

        } catch (ex: Exception) {

        }
        return json;
    }


    fun convertJsonToGson(): MutableList<JsonData> {

        val gsonConvertor: Gson = Gson()

        val jsonString = loadJson()

        val typeToken: TypeToken<MutableList<JsonData>> =
            object : TypeToken<MutableList<JsonData>>() {}

        val list: MutableList<JsonData> = gsonConvertor.fromJson(jsonString, typeToken.type)

        list.sortByDescending { it.date }

        return list
    }
}