package com.osos.appdeskservice.ui.home

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.osos.appdeskservice.api.ApiBuilder
import com.osos.appdeskservice.api.ApiCall
import com.osos.appdeskservice.data.Constants
import com.osos.appdeskservice.data.Response
import com.osos.appdeskservice.preferences.PreferenceClass
import kotlinx.coroutines.async
import kotlinx.coroutines.launch

class HomeViewModel : ViewModel() {


    var response:MutableLiveData<Response> = MutableLiveData()

    fun getWeather(lat : Double?, lang : Double? , unit : String = "metric") {
        Log.d("LOGS", "getWeather: ${lat.toString()} ${lang.toString()} ")

        viewModelScope.launch {
            val job = async {

                ApiBuilder.getApiCall().getWeather(lat.toString(),lang.toString(),Constants.API_KEY,unit)
            }
            response.value = job.await()
        }

    }







}