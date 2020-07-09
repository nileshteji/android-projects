package com.arcore.dependencyinjection;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStoreOwner;

import com.arcore.dependencyinjection.databinding.ActivityMainBinding;
import com.arcore.dependencyinjection.di.Component;
import com.arcore.dependencyinjection.di.DaggerComponent;
import com.arcore.dependencyinjection.viewmodel.MyViewModel;
import com.arcore.dependencyinjection.viewmodel.ViewModelFactory;


import javax.inject.Inject;

import dagger.Module;
import dagger.Provides;


public class MainActivity extends AppCompatActivity {


@Inject
ClassOne classOne;
MyViewModel viewModel;

static String TAG="Main Activity";

    // @Module  annotation is used for the class which is providing dependencies
    // @Provide annotation is used for the Method in the Module which provides Dependencies
    // @Inject annotation is used for the class which consumes dependencies
    // @Component annotation is used for the class which connects the @Module and @Inject
TextView activity;
ActivityMainBinding activityMainBinding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityMainBinding=ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(activityMainBinding.getRoot());

        activity=findViewById(R.id.text);
        // for this we need to inject the MainActivity
        // This line provides us with all the injection which are there in the Module which is connected to the Component
        DaggerComponent.create().inject(MainActivity.this);
        classOne.print();
        viewModel=new ViewModelProvider(MainActivity.this,new ViewModelFactory("Kumar.nilesh023@gmail.com","teji")).get(MyViewModel.class);
        viewModel.getStringMutableLiveData().observe(this, new Observer<String>() {
            @Override
            public void onChanged(String s) {
                    activityMainBinding.text.setText(s);
            }
        });




    }





    /// What is DaggerComponent Doing is it is giving us all the Dependencies which are included in the Modules of the Component


}