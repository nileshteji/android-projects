package com.osos.squareboatapplication.core.welcome

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.LivePagedListBuilder
import androidx.paging.PagedList
import com.osos.squareboatapplication.api.ApiBuilder
import com.osos.squareboatapplication.api.ApiCall
import com.osos.squareboatapplication.api.Constants
import com.osos.squareboatapplication.model.Article
import com.osos.squareboatapplication.pagination.ArticleDataFactory
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.async
import kotlinx.coroutines.launch

class NewsViewModel : ViewModel() {


    var newsDefault: MutableLiveData<List<Article>> = MutableLiveData()

    var mainList: LiveData<PagedList<Article>> = MutableLiveData()


    var apiCall: ApiCall = ApiBuilder.getApiCaller()

    val TAG = "LOGS"

    var exceptionHandler = CoroutineExceptionHandler { coroutineContext, throwable ->
        newsDefault.value = null
        Log.d(TAG, throwable.localizedMessage)
    }



    fun fetchTopHeadLines(country: String) {

        viewModelScope.launch(exceptionHandler) {
            var job = async {
                apiCall.default(country, Constants.API_KEY)
            }
            newsDefault.value = job.await().articles
        }

    }

    fun sortSources(list: List<String>) {

        Log.d(TAG, "sortSources: $list")
        viewModelScope.launch(exceptionHandler) {
            var job = async {
                apiCall.sortSources(list, Constants.API_KEY)
            }

            newsDefault.value = job.await().articles
        }

    }


    fun mainPagedList(a: String) {

        val config = PagedList.Config.Builder().build()

        mainList = LivePagedListBuilder<Int, Article>(ArticleDataFactory(a), config).build()

    }


    fun searchQuery(q: String?) {

        viewModelScope.launch(exceptionHandler) {
            var job = async {
                apiCall.querySearch(q!!, Constants.API_KEY)
            }
            newsDefault.value = job.await().articles

        }

    }

    fun categorizeSearch(q: String?, a: String) {

        viewModelScope.launch(exceptionHandler) {
            var job = async {

                apiCall.sort(q!!, a, Constants.API_KEY)
            }
            newsDefault.value = job.await().articles
        }
    }


    fun getHeadLines(): MutableLiveData<List<Article>> {
        return newsDefault
    }


}