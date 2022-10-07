package com.tyba.esperapplication.core

import android.content.Context
import android.content.Intent
import android.net.ConnectivityManager
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.observe
import androidx.recyclerview.widget.LinearLayoutManager
import com.tyba.common.changeData
import com.tyba.common.constants.Constants
import com.tyba.common.containsKey
import com.tyba.common.data.ExclusionBaseObject
import com.tyba.common.data.Option
import com.tyba.common.toMap
import com.tyba.esperapplication.R
import com.tyba.esperapplication.RVListeners.OptionRVClickListener
import com.tyba.esperapplication.adapters.FeatureAdapter
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity(), OptionRVClickListener {
    private val TAG = "MainActivity"
    val viewModel: MainViewModel by viewModels()
    val featureAdapter: FeatureAdapter = FeatureAdapter(this)
    val selectedFeaturesList = mutableListOf<String>()
    val optionsList: MutableList<Option> = mutableListOf()
    val exclusionList: MutableList<ExclusionBaseObject> = mutableListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        init()

        if (isNetworkAvailable()) {
            viewModel.getData(applicationContext)
        } else {
            viewModel.getFeatureCacheData(applicationContext)

        }

        viewModel.featureList.observe(this) {
            featureAdapter.submitList(it)
        }
        viewModel.exclusionsList.observe(this) {
            progressBar.visibility = View.GONE
            exclusionList.changeData(it)
        }

        get_features_list.setOnClickListener {
            Intent(this@MainActivity,DisplayActivity::class.java).apply {
                putParcelableArrayListExtra(Constants.INTENT_KEY,optionsList.toCollection(ArrayList()))
                startActivity(this)
            }
        }

    }

    fun init() {
        feature_recycler.apply {
            adapter = featureAdapter;
            layoutManager = LinearLayoutManager(this@MainActivity).apply {
                orientation = LinearLayoutManager.VERTICAL
            }
        }


    }

    private fun isNetworkAvailable(): Boolean {
        val connectivityManager =
            getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val activeNetworkInfo = connectivityManager.activeNetworkInfo
        return activeNetworkInfo != null && activeNetworkInfo.isConnected
    }

    override fun checkIfFeatureIncluded(featureSelected: String, option: Option): Boolean {
        val mutableMap: MutableMap<String, String> = exclusionList.toMap()
        Log.d(TAG, "checkIfFeatureIncluded: ${mutableMap}")

        val condition = when {
            mutableMap.containsKey(featureSelected) -> {
                Log.d(TAG, "checkIfFeatureIncluded:  Contains Key")
                !selectedFeaturesList.contains(mutableMap[featureSelected])

            }
            mutableMap.containsValue(featureSelected) -> {
                Log.d(TAG, "Contains Value: ")
                !selectedFeaturesList.containsKey(mutableMap, featureSelected)

            }
            else -> {
                true
            }

        }


        if (condition) {
            selectedFeaturesList.add(featureSelected)
            optionsList.add(option)
        }
        Log.d(TAG, "checkIfFeatureIncluded: ${selectedFeaturesList} ")
        return condition


    }

    override fun removeSelectedItem(featureSelected: String, option: Option) {
        selectedFeaturesList.remove(featureSelected)
        optionsList.forEach {
            if (it.id.equals(option.id)) {
                optionsList.remove(it)
            }
        }
    }
}