package com.arcore.dependencyinjection;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;

import com.arcore.dependencyinjection.databinding.ActivityMainBinding;

import dagger.Module;
import dagger.Provides;

@Module
public class MainActivity extends AppCompatActivity {
ActivityMainBinding mainBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mainBinding=ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(mainBinding.getRoot());
        





    }



    @Provides
   public  Context getInstance(){
        return getApplicationContext();
    }
}