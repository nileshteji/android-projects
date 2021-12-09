package com.osos.appdeskservice.ui.settings

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.osos.appdeskservice.preferences.PreferenceClass

class SettingsViewModel : ViewModel() {


    val userName:MutableLiveData<String> = MutableLiveData()




    fun getUserName(context: Context) { userName.value = PreferenceClass(context).getUsername() }



}