package com.osos.kotlinapplication

import android.app.Application
import android.view.View
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class nileshFactory(a:String):ViewModelProvider.Factory{

    var a:String=a;
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
           if(modelClass.isAssignableFrom(NileshViewModel::class.java)){
               return NileshViewModel(a) as T;
           }
            return null as T;
    }

}