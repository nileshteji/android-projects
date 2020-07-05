package com.arcore.dependencyinjection.viewmodel;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

public class ViewModelFactory implements ViewModelProvider.Factory {
    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {

        if(modelClass.isAssignableFrom(MyViewModel.class))
            return (T) new MyViewModel("Nilesh,Teji","Teji");
        else{
            return null;
        }
    }
}
