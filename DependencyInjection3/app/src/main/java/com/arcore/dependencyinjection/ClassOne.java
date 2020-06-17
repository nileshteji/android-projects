package com.arcore.dependencyinjection;

import android.util.Log;

import dagger.Module;
import dagger.Provides;

@Module
public class ClassOne {
static String TAG="ClassOne";

    @Provides
    ClassOne getInstance(){
        return  new ClassOne();
    }


    void print(){
        Log.d(TAG, "print: Dependency Injection");
    }
}
