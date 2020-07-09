package com.arcore.dependencyinjection.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

public class ViewModelFactory(email :String,password:String):ViewModelProvider.Factory{

val email=email
val password=password

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
      if (modelClass.isAssignableFrom(MyViewModel::class.java)){
          return MyViewModel(email,password) as T
      }
        else{
         throw IllegalArgumentException("Incorrect Creditionals")
      }
    }

}