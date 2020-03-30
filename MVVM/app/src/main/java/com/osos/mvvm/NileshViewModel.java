package com.osos.mvvm;

import android.database.Observable;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.ArrayList;
import java.util.List;

public class NileshViewModel extends ViewModel {

   MutableLiveData<String> obj=new MutableLiveData<>();




    public MutableLiveData<String> getData(){

        obj.setValue("Nilesh Teji ");
        return  obj;



    }





    
}
