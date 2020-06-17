package com.arcore.dependencyinjection;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.arcore.dependencyinjection.di.Component;
import com.arcore.dependencyinjection.di.DaggerComponent;

import javax.inject.Inject;

import dagger.Module;
import dagger.Provides;


public class MainActivity extends AppCompatActivity {


@Inject
ClassOne classOne;
Component component;

static String TAG="Main Activity";

    // @Module  annotation is used for the class which is providing dependencies
    // @Provide annotation is used for the Method in the Module which provides Dependencies
    // @Inject annotation is used for the class which consumes dependencies
    // @Component annotation is used for the class which connects the @Module and @Inject

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // for this we need to inject the MainActivity
        // This line provides us with all the injection which are there in the Module which is connected to the Component
        DaggerComponent.create().inject(MainActivity.this);
        classOne.print();





    }





    /// What is DaggerComponent Doing is it is giving us all the Dependencies which are included in the Modules of the Component


}