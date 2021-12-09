package com.osos.appdeskservice.ui.report

import android.content.Context
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.osos.appdeskservice.api.ApiBuilder
import com.osos.appdeskservice.api.ApiCall
import com.osos.appdeskservice.data.Constants
import com.osos.appdeskservice.data.SevenDayResponse
import com.osos.appdeskservice.preferences.PreferenceClass
import kotlinx.coroutines.async
import kotlinx.coroutines.launch

class ReportViewModel : ViewModel() {

    val userName: MutableLiveData<String> = MutableLiveData()
    var sevenDayResponse : MutableLiveData<SevenDayResponse> = MutableLiveData()

    fun getUserName(context: Context) { userName.value = PreferenceClass(context).getUsername() }


    fun getReport(lat : Double?, lang : Double? , unit : String = "metric"){

        viewModelScope.launch {

        val job = async {
            ApiBuilder.getApiCall()
                .sevenDayWeather(lat.toString(), lang.toString(), Constants.API_KEY, unit)
        }

            sevenDayResponse.value = job.await()

        }

    }


}