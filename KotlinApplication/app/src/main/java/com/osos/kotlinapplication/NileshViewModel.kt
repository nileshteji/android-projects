package com.osos.kotlinapplication

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class NileshViewModel(a:String): ViewModel() {


   var data= MutableLiveData<String>();
    var a=a;

    fun getUser(): MutableLiveData<String> {
        data.value=a;
        return data;
    }

    fun setData(name:String){
        data.value=name;
    }



}