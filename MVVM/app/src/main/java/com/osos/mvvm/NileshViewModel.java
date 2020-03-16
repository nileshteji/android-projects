package com.osos.mvvm;

import android.database.Observable;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.ArrayList;
import java.util.List;

public class NileshViewModel extends ViewModel {

   MutableLiveData<List<String>> obj=new MutableLiveData<>();

   public  NileshViewModel(String name){
        obj.setValue(new ArrayList<String>());
    }


    public MutableLiveData<List<String>> getData(){
        return obj;
    }





    
}
