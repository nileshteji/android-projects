package com.android.viewmodelfactory.viewModel;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

public class ViewModelFacotry implements  ViewModelProvider.Factory {

    String name;


    public ViewModelFacotry(String name){
          this.name=name;
    }
    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
          if(modelClass.isAssignableFrom(MainViewModel.class)){
              return (T) new  MainViewModel(name);
          }




        return null;
    }
}
