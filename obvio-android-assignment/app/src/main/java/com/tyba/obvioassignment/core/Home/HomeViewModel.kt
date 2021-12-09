package com.tyba.obvioassignment.core.Home

import android.app.Application
import android.content.Context
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.tyba.obvioassignment.ObvioApplication
import com.tyba.obvioassignment.data.JsonData
import com.tyba.obvioassignment.datasource.JsonDataSource
import kotlinx.coroutines.Dispatchers
import java.text.SimpleDateFormat
import java.time.LocalDate
import java.time.format.DateTimeFormatter
import java.util.*
import kotlin.Comparator


class HomeViewModel : ViewModel() {

    var _application = ObvioApplication.getIntance()
    var JsonList: MutableLiveData<List<JsonData>> = MutableLiveData()
    var jsonDataSource: JsonDataSource
    var list: MutableList<JsonData> = mutableListOf()

    init {
        jsonDataSource = JsonDataSource(_application)
    }

    fun getJsonList(){
        list = jsonDataSource.convertJsonToGson()
        JsonList.value = list
    }

    fun bookMarkTheItem(position:Int,isBookMark:Boolean){
        list[position].bookMark = isBookMark
    }







}