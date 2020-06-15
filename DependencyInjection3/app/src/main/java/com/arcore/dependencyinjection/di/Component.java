package com.arcore.dependencyinjection.di;

import com.arcore.dependencyinjection.MainActivity;

@dagger.Component(modules = MainActivity.class)
public interface Component {
    void inject(MainActivity mainActivity);
    
}
