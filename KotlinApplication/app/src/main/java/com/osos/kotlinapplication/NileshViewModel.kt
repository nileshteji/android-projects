package com.osos.kotlinapplication

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class NileshViewModel: ViewModel() {


   var data= MutableLiveData<String>();
    fun getUser(name:String): MutableLiveData<String> {
        data.value="Nilesh";
        return data;
    }

    fun setData(name:String){
        data.value=name;
    }

}