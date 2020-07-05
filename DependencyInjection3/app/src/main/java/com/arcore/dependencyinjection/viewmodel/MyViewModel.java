package com.arcore.dependencyinjection.viewmodel;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class MyViewModel extends ViewModel {
String a;String b;
MutableLiveData<String> stringMutableLiveData=new MutableLiveData<>();
    MyViewModel(String a ,String b){
     this.a=a;
     this.b=b;

    }

    public MutableLiveData<String> getStringMutableLiveData() {
        stringMutableLiveData.setValue(a+""+b);
        return stringMutableLiveData;
    }
}
