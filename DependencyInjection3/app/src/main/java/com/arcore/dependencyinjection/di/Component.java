package com.arcore.dependencyinjection.di;

import com.arcore.dependencyinjection.ClassOne;
import com.arcore.dependencyinjection.MainActivity;

@dagger.Component(modules = {ClassOne.class})
public interface Component {



    ClassOne getUser();




}
