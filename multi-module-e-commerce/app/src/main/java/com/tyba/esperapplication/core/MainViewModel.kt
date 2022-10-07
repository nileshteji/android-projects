package com.tyba.esperapplication.core

import android.content.Context
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.tyba.api.ApiBuilder
import com.tyba.api.ApiCalls
import com.tyba.common.changeToBaseObject
import com.tyba.common.data.Exclusion
import com.tyba.common.data.ExclusionBaseObject
import com.tyba.common.data.Feature
import com.tyba.repository.db.FeaturesDao
import com.tyba.repository.db.ImplRoomBuilder
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.schedulers.Schedulers


class MainViewModel : ViewModel() {

    lateinit var apiCalls: ApiCalls
    private val TAG = "MainViewModel"
    public var featureList: MutableLiveData<List<Feature>> = MutableLiveData()
    public var exclusionsList: MutableLiveData<List<ExclusionBaseObject>> = MutableLiveData()

    init {
        apiCalls = ApiBuilder.getApi()
    }


    fun getData(context: Context) {

        apiCalls.getRemoteData()
            .observeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                featureList.value = it.features
                exclusionsList.value = it.exclusions.changeToBaseObject()
                insertDataIntoCache(context, it.features, it.exclusions)
            },
                {
                    println(it)
                }
            )
    }

    fun getFeatureCacheData(context: Context) {
        var featureDao = ImplRoomBuilder.getDatabaseObj(context).featureDao()

        featureDao
            .getAllFeatures()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                featureList.value = it
                getExclusionCacheData(featureDao)
            }, {
                println("${it.message}")
            })
    }

    private fun getExclusionCacheData(featuresDao: FeaturesDao) {
        featuresDao.getAllExclusions()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                exclusionsList.value = it
            }, {
                println("${it.message}")
            })
    }


    private fun insertDataIntoCache(
        context: Context,
        data: List<Feature>,
        dataExclusions: List<List<Exclusion>>
    ) {
        val feature = ImplRoomBuilder.getDatabaseObj(context).featureDao()

        val modifiedList = dataExclusions.changeToBaseObject()

        feature.insertFeatures(data)
            .andThen(feature.insertExclusions(modifiedList))
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({

            }, {
                println(it.message)
            })
    }


}

