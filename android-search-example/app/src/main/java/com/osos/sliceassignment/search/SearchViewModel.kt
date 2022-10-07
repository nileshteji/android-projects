package com.osos.sliceassignment.search

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.osos.sliceassignment.api.ApiCalls
import com.osos.sliceassignment.api.ApiClient
import com.osos.sliceassignment.model.Tweets
import kotlinx.coroutines.async
import kotlinx.coroutines.launch
import retrofit2.Retrofit


class SearchViewModel : ViewModel() {

    var tweetsList = MutableLiveData<List<Tweets>>()


    fun apiCall(search:String){
        viewModelScope.launch {
            var tweetJOBS = async {
                ApiClient.apiCalls.getTweets().data
            }
            tweetsList.value=tweetJOBS.await()
        }
    }

    fun getList(): MutableLiveData<List<Tweets>> {
        return tweetsList
    }



}