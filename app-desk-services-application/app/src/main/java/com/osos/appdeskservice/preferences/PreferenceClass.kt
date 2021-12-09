package com.osos.appdeskservice.preferences

import android.content.Context
import android.content.SharedPreferences
import com.osos.appdeskservice.data.Constants
import com.osos.appdeskservice.data.Temp


class PreferenceClass(var context: Context) {


    var mPref: SharedPreferences
    var editor:SharedPreferences.Editor


    init {
        mPref = context.getSharedPreferences(Constants.PREF_NAME, Context.MODE_PRIVATE)
        editor=mPref.edit()

    }

    fun insertTemperature(a: Temp) {
        editor.putString(Constants.PREF_TEMP, a.name)
        editor.apply()
    }

    fun getTemperature(): String? {
        return mPref.getString(Constants.PREF_TEMP, Temp.CEL.name)
    }

    fun insertUserName(a: String) {
        editor.putString(Constants.PREF_USER, a)
        editor.apply()
    }

    fun getUsername(): String? {
        return mPref.getString(Constants.PREF_USER, null)
    }


}