package com.osos.mvvm;

import android.database.Observable;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class NileshViewModel extends ViewModel {

   MutableLiveData<String> obj=new MutableLiveData<>();

   public  NileshViewModel(String name){
        obj.setValue(name);
    }


    public MutableLiveData<String> getData(){
        return obj;
    }





    
}
