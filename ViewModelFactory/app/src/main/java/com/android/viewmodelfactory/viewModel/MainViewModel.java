package com.android.viewmodelfactory.viewModel;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class MainViewModel extends ViewModel {


MutableLiveData<String> stringMutableLiveData=new MutableLiveData<>();
String a="Nilesh";



public MainViewModel(String name){
     a=name;
}

public MutableLiveData<String> getString(){
     stringMutableLiveData.setValue(a);
     return stringMutableLiveData;
}











}
