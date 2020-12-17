package com.example.hiltandroidapplication.dagger;

import android.app.Application;

import dagger.BindsInstance;
import dagger.Component;
import dagger.android.AndroidInjector;

@Component
public interface AppComponent extends AndroidInjector<BaseApplication>{

    @Component.Builder
    interface Builder{

        @BindsInstance
        Builder application(Application application);
        AppComponent build();
    }
}