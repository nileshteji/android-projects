package com.osos.appdeskservice.ui.date

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.osos.appdeskservice.api.ApiBuilder
import com.osos.appdeskservice.data.Constants
import com.osos.appdeskservice.data.DateResponse
import com.osos.appdeskservice.data.Places
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.async
import kotlinx.coroutines.launch

class DateViewModel : ViewModel() {


    var history: MutableLiveData<DateResponse> = MutableLiveData()
    lateinit var lat: String
    lateinit var long: String

    var exceptionHandler = CoroutineExceptionHandler { coroutineContext, throwable ->
        Log.d("LOGs", " ${throwable.localizedMessage}")
       history.value = null
    }

    fun fetchResponse(place: Places, unix: Long, unit: String = "metric") {


        when (place) {

            Places.Delhi -> {

                lat = Constants.delhi_lat

                long = Constants.delhi_long

            }


            Places.Mumbai -> {

                lat = Constants.mumbai_lat

                long = Constants.mumbai_long

            }


            Places.Noida -> {

                lat = Constants.noida_lat

                long = Constants.noida_long

            }


        }


        viewModelScope.launch(exceptionHandler) {

            val job = async {
                ApiBuilder.getApiCall()
                    .getHistory(lat, long, unix.toString(), Constants.API_KEY, unit)
            }

            history.value = job.await()

        }

    }


}