package com.arcore.dependencyinjection;

import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;

import com.arcore.dependencyinjection.model.annotation;

public class MainActivity extends AppCompatActivity {
static String TAG="Main Activity";

    // @Module  annotation is used for the class which is providing dependencies
    // @Provide annotation is used for the Method in the Module which provides Dependencies
    // @Inject annotation is used for the class which consumes dependencies
    // @Component annotation is used for the class which connects the @Module and @Inject

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


    }
}